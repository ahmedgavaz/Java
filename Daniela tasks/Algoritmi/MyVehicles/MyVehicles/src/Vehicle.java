import java.time.Year;

public class Vehicle {
    private static int counter=1;
    private int vehicleID;
    private String vehicleDesc;
    private String vehicleType;
    private String licensePlate;
    private int yearOfProduction;
    private double vehicleValue;
    private int vehicleStoreID;

    //If vehicle isn't used on public roads it doesn't need a plate
    public Vehicle(String vehicleDesc, String vehicleType, int yearOfProduction, double vehicleValue) {
        setVehicleID(counter);
        setVehicleDesc(vehicleDesc);
        setVehicleType(vehicleType);
        setYearOfProduction(yearOfProduction);
        setVehicleValue(vehicleValue);
        counter++;
    }

    //If vehicle is used on public roads, so it needs a plate
    public Vehicle(String vehicleDesc, String vehicleType, String licensePlate, int yearOfProduction, double vehicleValue) {
        this(vehicleDesc,vehicleType,yearOfProduction,vehicleValue);
        setLicensePlate(licensePlate);
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public int getVehicleStoreID() {
        return vehicleStoreID;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
            str.append(getVehicleID()).append(" ")
                    .append(getVehicleDesc()).append(" ")
                    .append(getVehicleType()).append(" ")
                    .append(getLicensePlate()).append(" ")
                    .append(getYearOfProduction()).append(" ")
                    .append(getVehicleValue()).append(" ")
                    .append(getVehicleStoreID()).append(" ")
                    .append(System.lineSeparator());
        String string = str.toString();
        return string;
    }

    public void setVehicleStoreID(int vehicleStoreID) {
        this.vehicleStoreID = vehicleStoreID;
    }
}
