package com.example.cardealer.domain.dtos;

import org.springframework.jdbc.core.SqlReturnType;

import java.math.BigDecimal;

public class CustomerTotalSalesDTO {
    private String fullName;
    private Integer boughtCars;
    private BigDecimal spentMoney;

    public CustomerTotalSalesDTO() {
    }

    public CustomerTotalSalesDTO(String fullName, Integer boughtCars, BigDecimal spentMoney) {

        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
