package com.example.json_processing_exercise.repositories;

import com.example.json_processing_exercise.entities.Category;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "select * from category order by RAND() limit 1;",nativeQuery = true)
    Optional<Category> findRandomCategory();
    @Query("SELECT new com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO(c.name, count(p.id), avg (p.price), sum (p.price)) from Product p " +
            "join p.categories c " +
            "group by c.id" +
            " order by count(p.id)")
    Optional<List<CategoryTotalProductsDTO>> getCategorySummary();
    List<Category> findAll();
}
