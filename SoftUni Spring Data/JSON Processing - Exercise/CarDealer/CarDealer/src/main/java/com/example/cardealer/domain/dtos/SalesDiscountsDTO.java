package com.example.cardealer.domain.dtos;

import java.math.BigDecimal;

public class SalesDiscountsDTO {
    private CarDTO car;
    private String name;
    private double discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

    public SalesDiscountsDTO() {
    }


    public SalesDiscountsDTO(String make, String model, Long distance, String name, double discount, BigDecimal price) {
        this.car = new CarDTO(make,model,distance);
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = price.multiply(BigDecimal.valueOf(1-discount));
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
