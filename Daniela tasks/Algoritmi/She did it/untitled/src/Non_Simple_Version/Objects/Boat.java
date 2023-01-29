/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 *the characteristics of the object boat are defined
 * @author Daniela Dolenska
 */
public class Boat {
    private static int count =1;
    private int boatID;
    private String boatType;
    private int boatCapacity;
    private double boatPrice;

    /**
     * constructor that creates an instance of the class
     * @param boatType characteristic of the object boat
     * @param capacity characteristic of the object boat
     * @param boatPrice characteristic of the object boat
     */
    public Boat(String boatType, int capacity, double boatPrice) {
        this.boatID = count;
        this.boatType = boatType;
        this.boatCapacity=capacity;        
        this.boatPrice = boatPrice;
        count++;
    }


    //  defines how the visualisations of the object boat will be displayed
     // @return string with information about the bout
    @Override
    public String toString(){
       return "Boat {"+ "Boat ID: " + boatID + ", Type: " + boatType + ", Capacity: "+boatCapacity + ", Price: " + boatPrice +" Euro"+'}';
    }
    
    public int getBoatID() {
        return boatID;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public int getBoatCapacity() {
        return boatCapacity;
    }

    public void setBoatCapacity(int boatCapacity) {
        this.boatCapacity = boatCapacity;
    }
    
    public double getBoatPrice() {
        return boatPrice;
    }

    public void setBoatPrice(double boatPrice) {
        this.boatPrice = boatPrice;
    }

    /**
     * asks the user to enter boat type, boat capacity and boat price and then creates a boat object
     * the input of the user is checked for errors
     * @return gives the newly created boat object
     */
    public static Boat createBoat(){
        String boatType =  validateStringInput(ENTER_BOAT_TYPE);
        int boatCapacity=validateIntegerInput(ENTER_BOAT_CAPACITY);
        double boatPrice = validateDoubleInput(ENTER_BOAT_PRICE);
        return new Boat(boatType, boatCapacity, boatPrice);
    }
    
    /**
     * sets the type, capacity and price of the boat, which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateBoat(){
        String boatType =  validateStringInput(ENTER_BOAT_TYPE);
        setBoatType(boatType);
        int boatCapacity=validateIntegerInput(ENTER_BOAT_CAPACITY);
        setBoatCapacity(boatCapacity);
        double boatPrice = validateDoubleInput(ENTER_BOAT_PRICE);
        setBoatPrice(boatPrice);
    }
}

