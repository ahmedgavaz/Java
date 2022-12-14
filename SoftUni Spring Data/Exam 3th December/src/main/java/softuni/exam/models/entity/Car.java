package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.CarType;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column
    private CarType carType;
    @Column()
    private String carMake;
    @Column
    private String carModel;
    @Column
    private int year;
    @Column(unique = true)
    private String plateNumber;
    @Column
    private int kilometers;
    @Column
    private double engine;


    public Car(int id, CarType carType, String carMake, String carModel, int year, String plateNumber, int kilometers, double engine) {
        this.id = id;
        this.carType = carType;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.engine = engine;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
