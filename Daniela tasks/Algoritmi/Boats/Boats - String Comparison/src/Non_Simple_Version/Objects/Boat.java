/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 *
 * @author danie
 */
public class Boat {
    private static int count =1;
    private int boatID;
    private String boatType;
    private double boatPrice;

    private Boat(String boatType, double boatPrice) {
        this.boatID = count;
        this.boatType = boatType;
        this.boatPrice = boatPrice;
        count++;
    }

    @Override
    public String toString(){
       return "Boat ID: " + boatID + "\nType: " + boatType + "\nPrice: " + boatPrice+"\n";
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

    public double getBoatPrice() {
        return boatPrice;
    }

    public void setBoatPrice(double boatPrice) {
        this.boatPrice = boatPrice;
    }

    public static Boat createBoat(){
        String boatType =  validateStringInput(ENTER_BOAT_TYPE);
        double boatPrice = validateDoubleInput(ENTER_BOAT_PRICE);
        return new Boat(boatType,boatPrice);
    }
    public void updateBoat(){
        String boatType =  validateStringInput(ENTER_BOAT_TYPE);
        setBoatType(boatType);
        double boatPrice = validateDoubleInput(ENTER_BOAT_PRICE);
        setBoatPrice(boatPrice);
    }
}

