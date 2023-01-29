/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 * deals with the functionalities that the boat menu presents
 * @author Daniela Dolenska
 */
public class BoatManager {
    /**
     * the maximum number of boats that must be created is 50
     */
    private static final int MAX_SIZE = 50;

    /**
     * array of type Boat that stores all the created boats
     */
    private static ArrayList<Boat> boatList = new ArrayList<>();

//
    public static void addBoat() {
        if (boatList.size()-1 < MAX_SIZE) {
            Boat newBoat=Boat.createBoat();
            boatList.add(newBoat);
            System.out.println(ADDED_MESSAGE + newBoat.toString());
            returnToSubMenu();
        } else {
            System.out.println(MAX_CAPACITY_REACHED);
        }
    }

    /**
     * asks user for boat id to update, and if there is such an id in the boatList, the boat will be updated
     * if the boat list is empty nothing will be done
     */
    public static void updateBoat() {
        if (boatList.size() == 0) {
            System.out.println(NO_BOATS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromBoatList(BOATS_ID_FOR_UPDATE);
            if (ID==null){
                return;
            }
            for (Boat boat : boatList) {
                if (boat.getBoatID() == ID) {
                    boat.updateBoat();
                    System.out.println(UPDATE + boat.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for boat id to delete, if there is a boat with such an id, it will be deleted
     * if the boat list is empty nothing will be done
     */
    public static void deleteBoat() {
        if (boatList.size() == 0) {
            System.out.println(NO_BOATS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromBoatList(BOAT_ID_FOR_DELETING);
            if (ID==null){
                return;
            }

            int size = boatList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (boatList.get(i).getBoatID() == ID) {
                    boatList.remove(i);
                    System.out.println(DELETION);
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created boats in the list will be displayed on the console
     */
    public static void listBoats() {
        if (boatList.size() == 0) {
            System.out.println(NO_BOATS_IN_THE_LIST);
        } else {
            System.out.println(BOATS_IN_THE_LIST);
            for (Boat boat : boatList) {
                System.out.println(boat.toString());
            }
        }
        returnToSubMenu();
    }

    /**
     * checks whether there is a boat in the list with the same id
     * @param str output message on the console
     * @return returns the boat or null if it does not exist
     */
    public static Integer validateIDFromBoatList(String str) {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < boatList.size(); i++) {
                    if (boatList.get(i).getBoatID() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_BOAT_WITH_THIS_ID);
            }catch (NoSuchElementException ex){
                System.out.println(ex.getMessage());
                returnToSubMenu();
                return null;
            }
            catch (Exception e) {
                System.out.println(INVALID_INPUT_MESSAGE);
                returnToSubMenu();
                return null;
            }
    }

    /**
     * asks the user to enter a specific attribute
     * searches for boat that have a particular characteristic, such as type, price, capacity
     * all boats owning this attribute will be displayed
     */
    public static void searchBoat() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Boat> list = new ArrayList<>();
        boolean isFound = false;
            for (int i = 0; i < boatList.size(); i++) {
                if (String.valueOf(boatList.get(i).getBoatID()).equals(attribute) ||
                        String.valueOf(boatList.get(i).getBoatCapacity()).equals(attribute)
                        || String.valueOf(boatList.get(i).getBoatPrice()).equals(attribute) ||
                        boatList.get(i).getBoatType().equals(attribute)) {
                    isFound = true;
                    list.add(boatList.get(i));
                }
        }
        if (!isFound) {
            System.out.println(NO_ELEMENT_FOUND);
        } else {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } returnToSubMenu();
    }
    
    public static void create3TestBoats() {        
        Boat boat1=new Boat ("little boat", 4, 1000);
        Boat boat2=new Boat("big boat", 10, 2500);
        Boat boat3=new Boat("bigger boat", 20, 5000);
        boatList.add(boat1);
        boatList.add(boat2);
        boatList.add(boat3);
    }
}
