package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentDTOWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ModelMapper modelMapper, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("src/main/resources/files/xml/apartments.xml");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        JAXBContext context = JAXBContext.newInstance(ApartmentDTOWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ApartmentDTOWrapper list = (ApartmentDTOWrapper) unmarshaller.unmarshal(Path.of("src/main/resources/files/xml/apartments.xml").toFile());
        list.getList().forEach(elem -> {
            if (elem.isValid()) {
                if (apartmentRepository.findFirstByAreaAndTown(elem.getArea(),
                        townRepository.findFirstByTownName(elem.getTown()).orElseThrow()).isEmpty()) {
                    Apartment apartment = modelMapper.map(elem, Apartment.class);
                    apartment.setTown(townRepository.findFirstByTownName(elem.getTown()).orElseThrow());
                    stringBuilder.append(String.format("Successfully imported apartment %s - %.2f"
                            , apartment.getApartmentType(), apartment.getArea())).append(System.lineSeparator());
                    apartmentRepository.saveAndFlush(apartment);
                } else {
                    stringBuilder.append("Invalid apartment").append(System.lineSeparator());
                }
            } else {
                stringBuilder.append("Invalid apartment").append(System.lineSeparator());
            }
        });
        return stringBuilder.toString();
    }
}
