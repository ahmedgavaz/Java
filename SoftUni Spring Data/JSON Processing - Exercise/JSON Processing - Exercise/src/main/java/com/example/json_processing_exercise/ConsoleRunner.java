package com.example.json_processing_exercise;

import com.example.json_processing_exercise.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedServiceImpl seedService;
    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;
    private final CategoryServiceImpl categoryService;

    @Autowired
    public ConsoleRunner(SeedServiceImpl seedService, ProductServiceImpl productService, UserServiceImpl userService, CategoryServiceImpl categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedService.seedAll();
        //productService.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        //userService.findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc();
        //categoryService.findAllByCountOfProducts();
        userService.fourthQuery();
    }
}
