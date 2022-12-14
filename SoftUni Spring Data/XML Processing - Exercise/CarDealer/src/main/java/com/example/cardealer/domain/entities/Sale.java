package com.example.cardealer.domain.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double discountPercentage;
    @OneToOne
    @Fetch(FetchMode.JOIN)
    private Car car;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Customer customer;

    public Sale() {
    }

    public Sale(double discountPercentage, Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
        setDiscountPercentage(discountPercentage);
    }

    public Sale(long id, double discountPercentage, Car car, Customer customer) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        setDiscountPercentage(discountPercentage);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (customer.isYoungDriver()){
            this.discountPercentage=discountPercentage+5;
        }else{
            this.discountPercentage = discountPercentage;
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
