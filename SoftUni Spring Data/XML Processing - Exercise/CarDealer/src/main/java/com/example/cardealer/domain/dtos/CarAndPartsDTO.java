package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarAndPartsDTO {
    @XmlElement( name = "car")
    private CarDTO car;
    @XmlElement(name = "parts")
    private List<PartNameAndPriceDTO> parts;

    public CarAndPartsDTO() {
    }

    public CarAndPartsDTO(CarDTO carDTO, List<PartNameAndPriceDTO> parts) {
        this.car = carDTO;
        this.parts = parts;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public List<PartNameAndPriceDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartNameAndPriceDTO> parts) {
        this.parts = parts;
    }
}
