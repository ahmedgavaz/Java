package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.SalesDiscountsDTO;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    List<SalesDiscountsDTO> findAllBy();
}
