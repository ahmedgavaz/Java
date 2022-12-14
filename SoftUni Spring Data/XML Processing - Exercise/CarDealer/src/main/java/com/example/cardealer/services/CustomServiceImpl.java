package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.*;
import com.example.cardealer.domain.entities.Customer;
import com.example.cardealer.domain.entities.Sale;
import com.example.cardealer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.*;

@Service
public class CustomServiceImpl implements CustomService{
    private final CustomerRepository customerRepository;

    public CustomServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllOrderedByBirthDate() {
        return this.customerRepository.findAllOrderedByBirthDate().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<CustomerTotalSalesDTO> findAllBySalesIsNotNull() {
        return this.customerRepository.findAllBySalesIsNotNull().orElseThrow(NoSuchElementException::new);
    }

    public void orderedCustoms() throws IOException, JAXBException {
        List<CustomerOrderDTO> list = findAllOrderedByBirthDate().stream()
                .map(e->{
                    //Превръщам рожденната дата в стринг
                    String date = String.valueOf(e.getBirthDate());
                    CustomerOrderDTO customerOrderDTO = modelMapper.map(e,CustomerOrderDTO.class);
                    customerOrderDTO.setBirthDate(date);
                    return customerOrderDTO;
                })
                //Тук изпразвам сетовете със Sale, защото става едно безкрайно пълнене във файла.
                //Също и във примера сетовете бяха празни
                .map(elem->{
                    elem.getSales().clear();
                    return elem;
                }).collect(Collectors.toList());
        FileWriter fileWriter = new FileWriter(new File(QUERY1_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(OrderedCustomsWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        OrderedCustomsWrapper orderedCustomsWrapper = new OrderedCustomsWrapper(list);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(orderedCustomsWrapper,fileWriter);
    }

    public void totalSalesByCustomer() throws IOException, JAXBException {
        List<CustomerTotalSalesDTO> list = findAllBySalesIsNotNull().stream().toList();
        CustomerTotalSalesWrapper customerTotalSalesWrapper = new CustomerTotalSalesWrapper(list);
        FileWriter fileWriter = new FileWriter(new File(QUERY5_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(CustomerTotalSalesWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(customerTotalSalesWrapper,fileWriter);
    }
}
