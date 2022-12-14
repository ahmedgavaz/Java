package com.example.json_processing_exercise.entities.dto;

import java.math.BigDecimal;

public class ProductInRangeDTO {
    private String name;
    private BigDecimal price;
    private String seller;

    public ProductInRangeDTO(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public ProductInRangeDTO() {
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
