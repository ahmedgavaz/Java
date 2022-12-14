package com.example.cardealer.services;
import com.example.cardealer.domain.dtos.SalesDiscountWrapper;
import com.example.cardealer.domain.dtos.SalesDiscountsDTO;
import com.example.cardealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.*;

@Service
public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<SalesDiscountsDTO> findAllBy() {
        return this.saleRepository.findAllBy().orElseThrow(NoSuchElementException::new);
    }

    public void salesWithAppliedDiscount() throws IOException, JAXBException {
        List<SalesDiscountsDTO> list = findAllBy();
        SalesDiscountWrapper salesDiscountWrapper = new SalesDiscountWrapper(list);
        FileWriter fileWriter = new FileWriter(new File(QUERY6_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(SalesDiscountWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(salesDiscountWrapper,fileWriter);
    }
}
