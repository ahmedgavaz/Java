/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author danie
 */
class Vehicle {
    //private static int counter = 1;
    private int vehicleID;
    private String vehicleDesc;
    private String vehicleType;
    private String licensePlate;
    private int yearOfProduction;
    private double vehicleValue;
    private int vehicleStoreID;

    //If vehicle isn't used on public roads it doesn't need a plate
    public Vehicle(String vehicleDesc, String vehicleType, int yearOfProduction, double vehicleValue) {
        this.vehicleDesc = vehicleDesc;
        this.vehicleType = vehicleType;
        this.yearOfProduction = yearOfProduction;
        this.vehicleValue = vehicleValue;
    }

    //If vehicle is used on public roads, so it needs a license plate, so a build another constructor
    public Vehicle(String vehicleDesc, String vehicleType, String licensePlate, int yearOfProduction, double vehicleValue) {
        this(vehicleDesc, vehicleType, yearOfProduction, vehicleValue);
        setLicensePlate(licensePlate);
    }

    @Override
    public String toString() {
        if (this.getLicensePlate()== null){
            return "Vehicle {" + "vehicleID: " + vehicleID + ", description: " + vehicleDesc
                    + ", type: " + vehicleType + ", year of production: " + yearOfProduction + ", value: "
                    + vehicleValue + " Euro" + ", vehicle store: " + vehicleStoreID + '}';
        }
        return "Vehicle {" + "vehicleID: " + vehicleID + ", description: " + vehicleDesc
                + ", type: " + vehicleType + ", license plate: " + licensePlate
                + ", year of production: " + yearOfProduction + ", value: " + vehicleValue + " Euro"
                + ", vehicle store: " + vehicleStoreID + '}';
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

    public void setVehicleStoreID(int vehicleStoreID) {
        this.vehicleStoreID = vehicleStoreID;
    }

}