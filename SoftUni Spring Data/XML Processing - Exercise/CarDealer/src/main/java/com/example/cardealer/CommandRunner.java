package com.example.cardealer;

import com.example.cardealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedServiceImpl seedService;
    private final CustomServiceImpl customService;
    private final CarServiceImpl carService;
    private final SupplierServiceImpl supplierService;
    private final SaleServiceImpl saleService;

    @Autowired
    public CommandRunner(SeedServiceImpl seedService, CustomServiceImpl customService, CarServiceImpl carService, SupplierServiceImpl supplierService, SaleServiceImpl saleService) {
        this.seedService = seedService;
        this.customService = customService;
        this.carService = carService;
        this.supplierService = supplierService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();
        customService.orderedCustoms();
        carService.CarsFromMakeToyota();
        supplierService.localSupplier();
        carService.carsWithTheirListOfParts();
        customService.totalSalesByCustomer();
        saleService.salesWithAppliedDiscount();
    }
}
