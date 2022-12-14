package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExtractingElement;
import softuni.exam.models.dto.OfferDTOWrapper;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count()>0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("src/main/resources/files/xml/offers.xml");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            stringBuilder.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        JAXBContext context = JAXBContext.newInstance(OfferDTOWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        List<Offer> list = new ArrayList<>();
        OfferDTOWrapper offerDTOWrapper = (OfferDTOWrapper) unmarshaller.unmarshal(Path.of("src/main/resources/files/xml/offers.xml").toFile());
        offerDTOWrapper.getList().forEach(elem->{
            if (elem.isValid()){
                if (agentRepository.findFirstByFirstName(elem.getAgentName().getName()).isEmpty() &&
                agentRepository.findFirstByLastName(elem.getAgentName().getName()).isEmpty()){
                    stringBuilder.append("Invalid offer").append(System.lineSeparator());
                }else{
                    Offer offer  = modelMapper.map(elem,Offer.class);
                    String[] date = elem.getPublishedOn().split("/");
                    offer.setId(0);
                    offer.setPublishedOn(LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0])));
                    offer.setAgent(agentRepository.findFirstByFirstName(elem.getAgentName().getName()).orElseThrow());
                    offer.setApartment(apartmentRepository.findFirstById(elem.getApartmentId().getId()).orElseThrow());
                    list.add(offer);
                    stringBuilder.append(String.format("Successfully imported offer %.2f",offer.getPrice())).append(System.lineSeparator());
                }
            }else {
                stringBuilder.append("Invalid offer").append(System.lineSeparator());
            }
        });
        offerRepository.saveAllAndFlush(list);
        return stringBuilder.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder stringBuilder = new StringBuilder();
        List<ExtractingElement> list = offerRepository.findTheBestOffers().orElseThrow();
        list.forEach(elem->{
            String str =String.format("Agent %s %s with offer №%d:\n" +
                    "\t\t-Apartment area: %.2f\n" +
                    "\t\t--Town: %s\n" +
                    "\t\t---Price: %.2f$",elem.getFirstName(),elem.getAgentLastName(),
                    elem.getOfferId(),elem.getApartmentArea(),elem.getTownName(),elem.getOfferPrice());
            stringBuilder.append(str).append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}
