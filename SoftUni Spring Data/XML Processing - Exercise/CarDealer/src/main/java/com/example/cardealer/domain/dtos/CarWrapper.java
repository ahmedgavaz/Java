package com.example.cardealer.domain.dtos;

import com.example.cardealer.domain.entities.Car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapper {
    @XmlElement(name = "car")
    private List<CarDTO> list;


    public CarWrapper(List<CarDTO> list) {
        this.list = list;
    }

    public List<CarDTO> getList() {
        return list;
    }

    public void setList(List<CarDTO> list) {
        this.list = list;
    }

    public CarWrapper() {
    }
}
