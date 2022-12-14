package softuni.exam.models.dto;


import softuni.exam.models.entity.enums.CarType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDTO {
    @XmlElement(name = "carType")
    private CarType carType;
    @XmlElement(name = "carMake")
    private String carMake;
    @XmlElement(name = "carModel")
    private String carModel;
    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "plateNumber")
    private String plateNumber;
    @XmlElement(name = "kilometers")
    private int kilometers;
    @XmlElement(name = "engine")
    private double engine;

    public CarDTO() {
    }

    public CarDTO(CarType carType, String carMake, String carModel, int year, String plateNumber, int kilometers, double engine) {
        this.carType = carType;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public boolean isValid() {
        if (carMake.length() < 2 || carMake.length() > 30 || carModel.length() < 2 || carModel.length() > 30
                || year <= 0 || plateNumber.length() < 2 || plateNumber.length() > 30 || engine < 1) {
            return false;
        }
        return true;
    }
}
