/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;


import java.io.*;
import java.io.IOException;

import newpackage.Car;
import java.util.ArrayList;



/**
 *
 * @author Petya Tetevenska
 */
public class CarManager {

    private static CarManager carManager;
    private CarManager(){       
    }
    public static CarManager getTheCarManager(){  //the method returns the only existing car manager
        if(carManager == null){
            carManager = new CarManager();
        }
        return carManager;
    }
    
    public static ArrayList<Car> carsList = new ArrayList<Car>(); //creating a list for storing the objects of class Car

    
    public Car getCar(int carID) {  // returns the car with ID <carID> or null if it does NOT exist
        for (Car theCar : carsList) { 
            if (theCar.getId()== carID) {
                return theCar; 
            }
        }
        return null; // car was not found
    }
    
    public boolean addCar(int iD, String userName) {
        Car newCar = new Car(iD, userName);
        if (getCar(iD) == null) { // list does NOT contain this car information 
            carsList.add(newCar); //  is added to list of cars
            return true;
        } else {
            return false; 
        }
    }


    public void delete(int deleteThisID) {  // the method deletes the car with the ID: deleteThisID 
        int carID;
        for (Car theCar : carsList) { 
            carID = theCar.getId();
            if (carID == deleteThisID) { //the car in the list has the same ID like deleteThisID 
                carsList.remove(theCar);
                break; 
            }
        }
    }
    
    public void update(int iD, int newID, String nameOfDriver){  // the method updates the car with ID corresponding to iD
        int theId;
        for(Car car : carsList){
            theId = car.getId();
            if(theId == iD){
                car.setId(newID);
                car.setNameOfUser(nameOfDriver);
                break;
            }
        }
    }
    
    public static void createTestCars(){ // the method creates cars for test purposes and saves them in the ArrayList
        if(carsList.isEmpty()){
        carsList.add(new Car(1234, "Daniel"));
        carsList.add(new Car(2583, "Lilly"));
        carsList.add(new Car(3697, "Sofia"));
        carsList.add(new Car(4562, "John"));
        carsList.add(new Car(7891, "Alexander"));
        }
        
    }
    
    public static ArrayList<Car> getCars() {
        return carsList;
    }

    public void printAllCars() { // a method for test purposes 
        for (Car aCar : carsList) {
            System.out.println(aCar);
        }
    }
    
   
    
    
    public static void serialize(){
        try {
            new ObjectOutputStream(new FileOutputStream("Cars.ser")).writeObject(carsList);
        } catch (IOException ex) {
            System.out.println("Something went wrong during cars serialization!");
        }
    }
    
    public static void deserialize(){
        try {
           carsList = (ArrayList<Car>) new ObjectInputStream(new FileInputStream("Cars.ser")).readObject();
        } catch (Exception ex) {
            System.out.println("Something went wrong during cars deserialization!");
        }
    }
    



 
    


}
