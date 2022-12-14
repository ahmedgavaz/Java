package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.CustomerDTO;
import com.example.cardealer.domain.dtos.CustomerDTOWithID;
import com.example.cardealer.domain.dtos.CustomerTotalSalesDTO;
import com.example.cardealer.domain.entities.Customer;
import com.example.cardealer.domain.entities.Sale;
import com.example.cardealer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public void orderedCustoms() throws IOException {
        List<CustomerDTOWithID> list = findAllOrderedByBirthDate().stream()
                .map(e->modelMapper.map(e,CustomerDTOWithID.class))
                //Тук изпразвам сетовете със Sale, защото става едно безкрайно пълнене във файла.
                //Също и във примера сетовете бяха празни
                .map(elem->{
                    elem.getSales().clear();
                    return elem;
                }).collect(Collectors.toList());
        writingJSON(QUERY1_PATH_WRITING,list);
    }

    public void totalSalesByCustomer() throws IOException {
        List<CustomerTotalSalesDTO> list = findAllBySalesIsNotNull().stream().toList();
        writingJSON(QUERY5_PATH_WRITING,list);
    }
}
