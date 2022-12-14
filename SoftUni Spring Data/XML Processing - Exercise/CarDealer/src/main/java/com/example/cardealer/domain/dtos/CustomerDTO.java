package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDTO {
    @XmlAttribute
    private String name;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String birthdate, boolean isYouthDriver) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
