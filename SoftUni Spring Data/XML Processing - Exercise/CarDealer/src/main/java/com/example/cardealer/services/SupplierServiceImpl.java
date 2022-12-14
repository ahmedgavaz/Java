package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.LocalSupplierWrapper;
import com.example.cardealer.domain.dtos.SupplierDTOWithCountOfParts;
import com.example.cardealer.domain.entities.Supplier;
import com.example.cardealer.repositories.SupplierRepository;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.*;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAllByIsImporterFalse() {
        return this.supplierRepository.findAllByIsImporterFalse().orElseThrow(NoSuchElementException::new);
    }

    public void localSupplier() throws IOException, JAXBException {
        List<SupplierDTOWithCountOfParts> list = findAllByIsImporterFalse().stream()
                .map(elem->{
                    SupplierDTOWithCountOfParts e = modelMapper.map(elem,SupplierDTOWithCountOfParts.class);
                    e.setPartsCount(elem.getParts().size());
                    return e;
                })
                .collect(Collectors.toList());
        LocalSupplierWrapper localSupplierWrapper = new LocalSupplierWrapper(list);
        FileWriter fileWriter = new FileWriter(new File(QUERY3_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(LocalSupplierWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(localSupplierWrapper,fileWriter);
    }
}
