package com.example.cardealer.domain.dtos;

import com.example.cardealer.domain.entities.Sale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Set;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDTOWithID {
    @XmlElement
    private Long id;
    @XmlElement
    private String name;
    @XmlElement(name = "birth-date")
    private LocalDateTime birthDate;
    @XmlElement(name="is-young-driver")
    private boolean isYoungDriver;

    private Set<Sale> sales;

    public CustomerDTOWithID() {
    }

    public CustomerDTOWithID(Long id, String name, LocalDateTime birthDate, boolean isYoungDriver) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
    }

    public CustomerDTOWithID(Long id, String name, LocalDateTime birthDate, boolean isYoungDriver, Set<Sale> sales) {
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
