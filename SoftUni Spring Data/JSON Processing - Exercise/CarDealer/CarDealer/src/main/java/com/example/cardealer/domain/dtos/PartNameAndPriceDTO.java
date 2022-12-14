package com.example.cardealer.domain.dtos;

import java.math.BigDecimal;

public class PartNameAndPriceDTO {
    private String name;
    private BigDecimal price;

    public PartNameAndPriceDTO() {
    }

    public PartNameAndPriceDTO(String name, BigDecimal price) {
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
