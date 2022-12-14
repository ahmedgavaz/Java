package com.example.json_processing_exercise.entities.dto;

import java.util.List;

public class CountAndProductsDTO {
    private Long count;
    private List<ProductDTO> products;

    public CountAndProductsDTO() {
    }

    public CountAndProductsDTO(List<ProductDTO> products) {
        this.count= Long.valueOf(products.size());
        this.products = products;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
