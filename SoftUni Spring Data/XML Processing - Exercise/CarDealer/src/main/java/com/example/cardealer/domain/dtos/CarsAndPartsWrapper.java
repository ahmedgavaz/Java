package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsAndPartsWrapper {
    @XmlElement(name = "car")
    List<CarsAndPartsTogether> list;

    public CarsAndPartsWrapper(List<CarsAndPartsTogether> list) {
        this.list = list;
    }

    public CarsAndPartsWrapper() {
    }

    public List<CarsAndPartsTogether> getList() {
        return list;
    }

    public void setList(List<CarsAndPartsTogether> list) {
        this.list = list;
    }
}
