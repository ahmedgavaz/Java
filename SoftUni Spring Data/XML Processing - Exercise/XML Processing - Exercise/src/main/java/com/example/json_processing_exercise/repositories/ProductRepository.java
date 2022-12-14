package com.example.json_processing_exercise.repositories;

import com.example.json_processing_exercise.entities.Product;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<List<Product>> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low,BigDecimal high);

    List<Product> findAll();
}
