/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 * @author danie
 */
class VehicleStore {
    private int counter = 1;
    private int vehicleStoreID;
    private static final int MAX_SIZE = 1000;

    //private final ArrayList<VehicleStore> vehicleStore= new ArrayList();
    private final ArrayList<Vehicle> listOfVehicles;

    public VehicleStore() {
        listOfVehicles = new ArrayList<>();
        vehicleStoreID = VehicleManager.countStores;
        VehicleManager.countStores++;
    }

    public int getVehicleStoreID() {
        return vehicleStoreID;
    }

    public void setVehicleStoreID(int vehicleStoreID) {
        this.vehicleStoreID = vehicleStoreID;
    }

    public void create5TestVehicles() {
        Vehicle vehicle1 = new Vehicle("Green", "Bike", 2015, 249.99);
        Vehicle vehicle2 = new Vehicle("Black", "e-Bike", 2022, 649.99);
        Vehicle vehicle3 = new Vehicle("White", "Boat", 2018, 6599.99);
        Vehicle vehicle4 = new Vehicle("Blue", "Car", "E 0177 BG", 2019, 22200);
        Vehicle vehicle5 = new Vehicle("Red", "Motorcycle", "SO 1914 TR", 2014, 3500);
        insertVehicle(vehicle1);
        insertVehicle(vehicle2);
        insertVehicle(vehicle3);
        insertVehicle(vehicle4);
        insertVehicle(vehicle5);
    }

    public void printAllVehicles() {
        for (Vehicle vehicle : listOfVehicles) {
            System.out.println(vehicle);
        }
    }

    public void cleanStore() {
        listOfVehicles.clear();
        counter = 0;
    }

    //returns the vehicle object from the vehicle list that has this ID number
    public Vehicle getVehicle(int vehicleID) {
        for (Vehicle vehicle : listOfVehicles) {  //iterates through every object in the array list
            if (vehicle.getVehicleID() == vehicleID) {   //if a vehicleID in the list is the same as th given number 
                return vehicle;
            }
        }
        System.out.println("not found");
        return null;   //indicates that there's no such vehicleID in the array list
    }

    public void insertVehicle(Vehicle vehicle) {
        if (listOfVehicles.size() < MAX_SIZE) {
            vehicle.setVehicleID(counter++);
            vehicle.setVehicleStoreID(vehicleStoreID);
            listOfVehicles.add(vehicle);
        } else {
            System.out.println("Full shop.");
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        for (int i = 0; i < listOfVehicles.size(); i++) {
            if (listOfVehicles.get(i).getVehicleID() == vehicle.getVehicleID()) {
                listOfVehicles.remove(listOfVehicles.get(i));
                vehicle.setVehicleStoreID(vehicleStoreID);
                listOfVehicles.add(i, vehicle);
                System.out.format("You updated vehicle: " + vehicle + "\n");
            }
        }
    }

    public boolean deleteVehicle(int vehicleID) {
        for (int i = 0; i < listOfVehicles.size(); i++) {
            if (listOfVehicles.get(i).getVehicleID() == vehicleID) {
                listOfVehicles.remove(listOfVehicles.get(i));
                return true;
            }
        }
        return false;
    }

    public  ArrayList<Vehicle>  searchVehicle(String attribute) {
        boolean isString = false;
        int countPoints=0;
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i)=='.'){
                countPoints++;
            }
            else if (attribute.charAt(i) > '9' || attribute.charAt(i) < '0' || countPoints>1) {
                isString = true;
                break;
            }
        }
        boolean isDouble = false;
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i) == '.') {
                isDouble = true;
                break;
            }
        }
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        if (isString) {
            for (Vehicle vehicle : listOfVehicles) {
                if (vehicle.getVehicleDesc().equals(attribute) || vehicle.getVehicleType().equals(attribute) || (vehicle.getLicensePlate() != null && vehicle.getLicensePlate().equals(attribute))) {
                    vehicleList.add(vehicle);
                }
            }
        } else if (isDouble) {
            for (Vehicle vehicle : listOfVehicles) {
                if (vehicle.getVehicleValue() == Double.parseDouble(attribute)) {
                    vehicleList.add(vehicle);
                }
            }
        } else {
            for (Vehicle vehicle : listOfVehicles) {
                if (vehicle.getVehicleID() == Integer.parseInt(attribute) || vehicle.getYearOfProduction() == Integer.parseInt(attribute) || vehicle.getVehicleValue() == Double.parseDouble(attribute)) {
                    vehicleList.add(vehicle);
                }
            }
        }
        return vehicleList;
    }
}
