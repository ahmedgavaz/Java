package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDiscountsDTO {
    @XmlElement
    private CarDTOAttribute car;
    @XmlElement(name = "customer-name")
    private String name;
    @XmlElement
    private double discount;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SalesDiscountsDTO() {
    }
    public SalesDiscountsDTO(String make, String model, long distance , String name, double discount, BigDecimal price, BigDecimal priceWithDiscount){
        this.car = new CarDTOAttribute(make,model,distance);
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }
//java.lang.String, java.lang.String, long, java.lang.String, double, java.math.BigDecimal

    public SalesDiscountsDTO(String make, String model, Long distance, String name, double discount, BigDecimal price) {
        this.car = new CarDTOAttribute(make,model,distance);
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = price.multiply(BigDecimal.valueOf(1-discount));
    }

    public CarDTOAttribute getCar() {
        return car;
    }

    public void setCar(CarDTOAttribute car) {
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
