package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import com.example.json_processing_exercise.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.json_processing_exercise.Constants.PathAndWriter.THIRD_QUERY;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryTotalProductsDTO> findAllByCountOfProducts() throws IOException {
        List<CategoryTotalProductsDTO> list =this.categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);
        PathAndWriter.writeInFile(list,THIRD_QUERY);
        return list;
    }
}
