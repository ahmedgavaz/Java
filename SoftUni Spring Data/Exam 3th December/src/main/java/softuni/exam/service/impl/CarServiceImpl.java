package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarWrapperDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Messages.IMPORTED_CAR;
import static softuni.exam.constants.Messages.INVALID_CAR;
import static softuni.exam.constants.Paths.CARS_PATH;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        JAXBContext context = JAXBContext.newInstance(CarWrapperDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CarWrapperDTO carWrapperDTo = (CarWrapperDTO) unmarshaller.unmarshal(Path.of(CARS_PATH).toFile());
        carWrapperDTo.getList().forEach(carDTO -> {
            if (carRepository.findFirstByPlateNumber(carDTO.getPlateNumber()).isEmpty()) {
                if (carDTO.isValid()) {
                    Car car = modelMapper.map(carDTO, Car.class);
                    stringBuilder.append(String.format(IMPORTED_CAR, car.getCarMake(), car.getCarModel()));
                    carRepository.saveAndFlush(car);
                } else {
                    stringBuilder.append(INVALID_CAR).append(System.lineSeparator());
                }
            } else {
                stringBuilder.append(INVALID_CAR).append(System.lineSeparator());
            }
        });
        return stringBuilder.toString();
    }
}
