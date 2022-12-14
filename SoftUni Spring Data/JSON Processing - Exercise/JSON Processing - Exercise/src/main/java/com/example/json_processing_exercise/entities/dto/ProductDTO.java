package com.example.json_processing_exercise.entities.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
