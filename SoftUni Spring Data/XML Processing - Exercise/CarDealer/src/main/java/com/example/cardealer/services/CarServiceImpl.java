package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.*;
import com.example.cardealer.domain.entities.Car;
import com.example.cardealer.repositories.CarRepository;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
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

    public void CarsFromMakeToyota() throws IOException, JAXBException {
        List<Car> list = findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota").stream()
                .map(elem -> modelMapper.map(elem, Car.class)).toList();
        CarDTOWrapper carDTOWrapper = new CarDTOWrapper(list);
        FileWriter fileWriter = new FileWriter(new File(QUERY2_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(CarDTOWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(carDTOWrapper,fileWriter);
    }

    public void carsWithTheirListOfParts() throws IOException, JAXBException {
        List<CarsAndPartsTogether> list = findAllBy().stream()
                .map(elem -> {
                    CarDTO cardto = modelMapper.map(elem, CarDTO.class);
                    CarAndPartsDTO car = modelMapper.map(elem, CarAndPartsDTO.class);
                    car.setCar(cardto);
                    return new CarsAndPartsTogether(car.getCar().getMake(), car.getCar().getModel(), car.getCar().getTravelledDistance(), new PartsWrapper(car.getParts()));
                }).toList();
        CarsAndPartsWrapper carsAndPartsWrapper = new CarsAndPartsWrapper(list);
        FileWriter fileWriter = new FileWriter(new File(QUERY4_PATH_WRITING));
        JAXBContext context = JAXBContext.newInstance(CarsAndPartsWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(carsAndPartsWrapper,fileWriter);
    }
}
