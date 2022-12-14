package com.example.cardealer.domain.dtos;

import java.util.List;

public class CarAndPartsDTO {
    private CarDTO car;
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
