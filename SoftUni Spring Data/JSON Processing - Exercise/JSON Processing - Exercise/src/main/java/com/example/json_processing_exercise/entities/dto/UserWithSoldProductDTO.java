package com.example.json_processing_exercise.entities.dto;

import java.util.List;

public class UserWithSoldProductDTO {
    private String firstName;
    private String lastName;
    private List<ProductSoldDTO> sellingProducts;

    public UserWithSoldProductDTO() {
    }

    public UserWithSoldProductDTO(String firstName, String lastName, List<ProductSoldDTO> boughtProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sellingProducts = boughtProducts;
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

    public List<ProductSoldDTO> getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(List<ProductSoldDTO> sellingProducts) {
        this.sellingProducts = sellingProducts;
    }
}
