package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.CustomerDTO;
import com.example.cardealer.domain.dtos.CustomerTotalSalesDTO;
import com.example.cardealer.domain.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomService {
    List<Customer> findAllOrderedByBirthDate();
    List<CustomerTotalSalesDTO> findAllBySalesIsNotNull();
}
