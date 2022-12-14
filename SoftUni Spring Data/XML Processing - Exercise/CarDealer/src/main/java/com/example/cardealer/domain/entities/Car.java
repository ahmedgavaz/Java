package com.example.cardealer.domain.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    private long id;
    @Column
    @XmlAttribute
    private String make;
    @Column
    @XmlAttribute
    private String model;
    @Column
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @ManyToMany()
    @Fetch(FetchMode.JOIN)
    @XmlTransient
    private Set<Part> parts;


    public Car() {
        parts = new HashSet<>();
    }

    public Car(long id, String make, String model, Long travelled) {
        this();
        this.id = id;
        this.make = make;
        this.model = model;
        this.travelledDistance = travelled;
    }

    public Car(long id, String make, String model, Long travelled, Set<Part> parts) {
        this();
        this.id = id;
        this.make = make;
        this.model = model;
        this.travelledDistance = travelled;
        this.parts = parts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(travelledDistance, car.travelledDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, travelledDistance);
    }
}
