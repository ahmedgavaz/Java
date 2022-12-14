package com.example.cardealer.domain.dtos;

import java.sql.Timestamp;

public class CustomerDTO {
    private String name;
    private Timestamp birthDate;
    private boolean isYoungDriver;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, Timestamp birthdate, boolean isYouthDriver) {
        this.name = name;
        this.birthDate = birthdate;
        this.isYoungDriver = isYouthDriver;
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
