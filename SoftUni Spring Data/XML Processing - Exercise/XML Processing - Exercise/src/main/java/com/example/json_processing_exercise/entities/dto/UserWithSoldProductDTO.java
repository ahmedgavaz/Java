package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductDTO {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElement(name = "sold-products")
    private ProductSoldWrapper sellingProducts;

    public UserWithSoldProductDTO() {
    }

    public UserWithSoldProductDTO(String firstName, String lastName, ProductSoldWrapper sellingProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sellingProducts = sellingProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProductSoldWrapper getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(ProductSoldWrapper sellingProducts) {
        this.sellingProducts = sellingProducts;
    }
}
