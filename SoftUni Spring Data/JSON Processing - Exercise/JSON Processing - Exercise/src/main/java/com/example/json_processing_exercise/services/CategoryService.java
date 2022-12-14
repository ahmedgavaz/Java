package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryTotalProductsDTO> findAllByCountOfProducts() throws IOException;
}
