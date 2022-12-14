package com.example.demo.services.category;

import com.example.demo.domain.entities.Category;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    void seedCategory(List<Category> categories);
    boolean isDatabaseSeeded();
    Set<Category> getRandomCategory();

}
