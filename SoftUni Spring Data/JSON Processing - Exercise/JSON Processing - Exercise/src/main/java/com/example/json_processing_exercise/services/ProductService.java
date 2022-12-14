package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import com.example.json_processing_exercise.entities.dto.ProductInRangeDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductInRangeDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException;

}
