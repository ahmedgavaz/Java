package com.example.cardealer.services;

import com.example.cardealer.domain.entities.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAllByIsImporterFalse();
}
