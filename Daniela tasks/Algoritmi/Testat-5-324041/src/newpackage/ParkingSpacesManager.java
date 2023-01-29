/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;

import java.util.ArrayList;



/**
 *
 * @author Petya Tetevenska
 */
public class ParkingSpacesManager {

    private static ParkingSpacesManager spacesManager;
    private ParkingSpacesManager(){       
    }
    public static ParkingSpacesManager getTheSpacesManager(){
        if(spacesManager == null){
            spacesManager = new ParkingSpacesManager();      
        }
        return spacesManager;
    }
    
    
    public static ArrayList<ParkingSpaces> spacesList = new ArrayList<ParkingSpaces>(); //creating a list for storing the objects of class Car
    

    
    public ParkingSpaces getSpaces(int position) {
        // returns the parking space with ID <carID> or null if it does NOT exist
        for (ParkingSpaces theSpaces : spacesList) { // for all cars in ArrayList:
            if (theSpaces.getPosition() == position) {
               return theSpaces;
            }
        }
        return null; // car not found!
    }
    
    public static void createTestParkingSpaces(){
        if(spacesList.isEmpty()){
        spacesList.add(new ParkingSpaces(12, "available"));
        spacesList.add(new ParkingSpaces(25, "occupied"));
        spacesList.add(new ParkingSpaces(36, "available"));
        spacesList.add(new ParkingSpaces(45, "available"));
        spacesList.add(new ParkingSpaces(78, "occupied"));
        }
        
    }
    
    public boolean addSpace(int position, String status) {
        ParkingSpaces newSpace = new ParkingSpaces(position, status);
        // if this space is NOT in ArrayList then add this space to the list
        if (getSpaces(position) == null) { // list does NOT contain this parking space ...
            spacesList.add(newSpace); // so it is added to list of parking spaces
            return true;
        } else {
            return false; // we do nothing and send <false> to the caller
        }
    }


    public void update(int position, int newPosition, String status){
        int thePosition;
        for(ParkingSpaces aSpace : spacesList){
            thePosition = aSpace.getPosition();
            if(thePosition == position){
                aSpace.setPosition(newPosition);
                aSpace.setStatus(status);
                break;
            }
        }
    }
    
    
    public void delete(int deleteThisSpace) {
        // deletes the parking space with the position: deleteThisSpace 
        int spacePosition;
        for (ParkingSpaces theSpace : spacesList) { // for all spaces in the ArrayList:
            spacePosition = theSpace.getPosition();
            if (spacePosition == deleteThisSpace) { // we found that parking space!
                spacesList.remove(theSpace);
                break; // no need for further loops!
            }
        }
    }
    
    public static ArrayList<ParkingSpaces> getSpaces() {
        return spacesList;
    }
    
    public static void serialize(){
        try {
            new ObjectOutputStream(new FileOutputStream("ParkingSpaces.ser")).writeObject(spacesList);
        } catch (IOException ex) {
            System.out.println("Something went wrong during spaces serialization!");
        }
    }
    
    public static void deserialize(){
        try {
           spacesList = (ArrayList<ParkingSpaces>) new ObjectInputStream(new FileInputStream("ParkingSpaces.ser")).readObject();
        } catch (Exception ex) {
            System.out.println("Something went wrong during spaces deserialization!");
        }
    }


    
}
