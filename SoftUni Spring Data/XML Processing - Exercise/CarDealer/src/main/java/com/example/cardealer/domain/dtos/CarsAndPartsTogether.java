package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsAndPartsTogether {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElement(name = "parts")
    private PartsWrapper partsWrapper;

    public CarsAndPartsTogether(String make, String model, Long travelledDistance, PartsWrapper partsWrapper) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.partsWrapper = partsWrapper;
    }

    public CarsAndPartsTogether() {
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

    public PartsWrapper getPartsWrapper() {
        return partsWrapper;
    }

    public void setPartsWrapper(PartsWrapper partsWrapper) {
        this.partsWrapper = partsWrapper;
    }
}
