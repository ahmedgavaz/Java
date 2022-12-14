package com.example.cardealer.domain.dtos;

import com.example.cardealer.domain.entities.Car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDTOWrapper {
    @XmlElement(name = "car")
    List<Car> list;

    public CarDTOWrapper() {
    }

    public CarDTOWrapper(List<Car> list) {
        this.list = list;
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }
}
