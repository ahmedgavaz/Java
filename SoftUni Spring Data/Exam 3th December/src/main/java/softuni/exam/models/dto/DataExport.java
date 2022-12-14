package softuni.exam.models.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class DataExport {
    private String carMake;
    private String carModel;
    private int kilometers;
    private String firstName;
    private String lastName;
    private int taskId;
    private double engine;
    private BigDecimal price;

    public DataExport(String carMake, String carModel, int kilometers, String firstName, String lastName, int taskId, double engine, BigDecimal price) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.kilometers = kilometers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.taskId = taskId;
        this.engine = engine;
        this.price = price;
    }

    public DataExport() {
    }

    public String getCarMake() {
        return carMake;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        String outputFormat = "Car %s %s with %dkm\n" +
                "-Mechanic: %s %s - task №%d:\n" +
                "--Engine: %s\n" +
                "---Price: %.2f$\n";
        String output = String.format(outputFormat, carMake, carModel, kilometers, firstName, lastName, taskId, format.format(engine), price.doubleValue());
        return output;
    }
}
