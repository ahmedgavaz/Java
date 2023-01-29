package Non_Simple_Version.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import static Non_Simple_Version.Validators.*;
import java.io.Serializable;

/**
 * the characteristics of the object boat are defined
 *
 * @author Daniela Dolenska
 */
public class Boat implements Serializable{

    public static int count = 1;
    private int boatID;
    private String boatType;
    private int boatCapacity;
    private double boatPrice;

    /**
     * constructor that creates an instance of the class
     *
     * @param boatType characteristic of the object boat
     * @param capacity characteristic of the object boat
     * @param boatPrice characteristic of the object boat
     */
    public Boat(String boatType, int capacity, double boatPrice) {
        this.boatID = count;
        this.boatType = boatType;
        this.boatCapacity = capacity;
        this.boatPrice = boatPrice;
        count++;
    }

    /**
     * defines how the visualisations of the object boat will be displayed
     *
     * @return string with information about the boat
     */
    @Override
    public String toString() {
        return "Boat {" + "Boat ID: " + boatID + ", Type: " + boatType + ", Capacity: " + boatCapacity + ", Price: " + boatPrice + " Euro" + '}';
    }

    /**
     * gets the ID of the boat object
     *
     * @return the boat ID
     */
    public int getBoatID() {
        return boatID;
    }

    /**
     * gets the type of the boat object
     *
     * @return the boat type
     */
    public String getBoatType() {
        return boatType;
    }

    /**
     * sets the new type of the boat
     *
     * @param boatType the new boat type
     */
    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    /**
     * gets the capacity of the boat object
     *
     * @return the capacity
     */
    public int getBoatCapacity() {
        return boatCapacity;
    }

    /**
     * sets the new capacity of the boat
     *
     * @param boatCapacity the new capacity
     */
    public void setBoatCapacity(int boatCapacity) {
        this.boatCapacity = boatCapacity;
    }

    /**
     * gets the price of the boat
     *
     * @return the price
     */
    public double getBoatPrice() {
        return boatPrice;
    }

    /**
     * sets the new price of the boat
     *
     * @param boatPrice the new price
     */
    public void setBoatPrice(double boatPrice) {
        this.boatPrice = boatPrice;
    }

    /**
     * asks the user to enter boat type, boat capacity and boat price and then
     * creates a boat object the input of the user is checked for errors
     *
     * @return gives the newly created boat object
     */
    public static Boat createBoat() {
        String boatType = validateStringInput("Enter boat type: ");
        int boatCapacity = validateIntegerInput("Enter boat capacity: ");
        double boatPrice = validateDoubleInput("Enter boat price: ");
        return new Boat(boatType, boatCapacity, boatPrice);
    }

    /**
     * receives type, capacity and the price of the boat
     * creates a boat object the input of the user is checked for errors
     *
     * @return gives the newly created boat object
     */
    public static Boat createBoat(String boatType,int boatCapacity,double boatPrice){
        validateString(boatType);
        validateInteger(boatCapacity);
        validateDouble(boatPrice);
        return new Boat(boatType, boatCapacity, boatPrice);
    }
    /**
     * sets the type, capacity and price of the boat, which the user wants to
     * update the input of the user is checked for errors
     */
    public void updateBoat() {
        String boatType = validateStringInput("Enter boat type: ");
        setBoatType(boatType);
        int boatCapacity = validateIntegerInput("Enter boat capacity: ");
        setBoatCapacity(boatCapacity);
        double boatPrice = validateDoubleInput("Enter boat price: ");
        setBoatPrice(boatPrice);
    }

    public Object getCapacity() {
       return this.boatCapacity;
    }

    public Object getPrice() {
      return this.boatPrice;
    }
}
