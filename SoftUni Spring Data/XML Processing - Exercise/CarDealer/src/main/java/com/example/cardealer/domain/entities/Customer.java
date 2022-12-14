package com.example.cardealer.domain.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private LocalDateTime birthDate;
    @Column
    private boolean isYoungDriver;
    @OneToMany(targetEntity = Sale.class,mappedBy = "customer")
    @Fetch(FetchMode.JOIN)
    private Set<Sale> sales;

    public Customer() {
    }

    public Customer(long id, String name, LocalDateTime birthdate, boolean isYouthDriver) {
        this.id = id;
        this.name = name;
        this.birthDate = birthdate;
        this.isYoungDriver = isYouthDriver;
    }

    public Customer(long id, String name, LocalDateTime birthdate, boolean isYouthDriver, Set<Sale> sales) {
        this.id = id;
        this.name = name;
        this.birthDate = birthdate;
        this.isYoungDriver = isYouthDriver;
        this.sales = sales;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
