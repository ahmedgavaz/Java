package com.example.cardealer.domain.dtos;

import com.example.cardealer.domain.entities.Sale;

import java.sql.Timestamp;
import java.util.Set;

public class CustomerDTOWithID {
    private Long id;
    private String name;
    private Timestamp birthDate;
    private boolean isYoungDriver;

    private Set<Sale> sales;

    public CustomerDTOWithID() {
    }

    public CustomerDTOWithID(Long id, String name, Timestamp birthDate, boolean isYoungDriver) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
    }

    public CustomerDTOWithID(Long id, String name, Timestamp birthDate, boolean isYoungDriver, Set<Sale> sales) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
        this.sales = sales;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
