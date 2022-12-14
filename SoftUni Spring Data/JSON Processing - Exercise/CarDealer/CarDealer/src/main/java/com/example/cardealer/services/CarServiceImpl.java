package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.CarAndPartsDTO;
import com.example.cardealer.domain.dtos.CarDTO;
import com.example.cardealer.domain.entities.Car;
import com.example.cardealer.repositories.CarRepository;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.*;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String model) {
        return this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(model).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Car> findAllBy() {
        return this.carRepository.findAllBy().orElseThrow(NoSuchElementException::new);
    }

    public void CarsFromMakeToyota() throws IOException {
        List<CarDTO> list = findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota").stream()
                .map(elem -> modelMapper.map(elem, CarDTO.class)).toList();
        writingJSON(QUERY2_PATH_WRITING,list);
    }

    public void carsWithTheirListOfParts() throws IOException {
        List<CarAndPartsDTO> list = findAllBy().stream()
                .map(elem->{
                    CarDTO cardto= modelMapper.map(elem,CarDTO.class);
                    CarAndPartsDTO car = modelMapper.map(elem,CarAndPartsDTO.class);
                    car.setCar(cardto);
                    return car;
                }).collect(Collectors.toList());
        writingJSON(QUERY4_PATH_WRITING,list);
    }
}
