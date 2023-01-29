package Non_Simple_Version.Management;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import Non_Simple_Version.Objects.Boat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Non_Simple_Version.Validators.*;

/**
 * deals with the functionalities that the boat menu presents. According to the
 * testat the business owns already 3 boats that is why with the start of the
 * program three test boats are created and when the user crates another one its
 * ID will be 4 and not 1.
 *
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

   /**
     * checks the array list whether there is more capacity to add a new boat in
     * it
     */
    public static void addBoat() {
        Boat newBoat;
        if (boatList.size() - 1 < MAX_SIZE) {
            newBoat = Boat.createBoat();
            boatList.add(newBoat);
            System.out.println("You added :\n" + newBoat.toString());
            returnToSubMenu();
        } else {
            System.out.println("The reached your capacity of boats.");
        }
    }
    
    /**
     * gets the list of boats
     *
     * @return the list of boat
     */
    public static ArrayList<Boat> getBoats(){
        return boatList;
    }
    
    /**
     * checks the array list whether there is more capacity to add a new boat in
     * it
     */
    
    public static void addBoat(String boatType,int boatCapacity,double boatPrice){
        Boat newBoat;
        if (boatList.size() - 1 < MAX_SIZE) {
            newBoat = Boat.createBoat( boatType, boatCapacity, boatPrice);
            boatList.add(newBoat);
        } else {
            System.out.print("The reached your capacity of boats.");
        }
    }

    /**
     * asks user for boat id to update, and if there is such an id in the
     * boatList, the boat will be updated if the boat list is empty nothing will
     * be done
     */
    public static void updateBoat(int id,String boatType,int boatCapacity,double boatPrice) {
            boatList.get(id).setBoatCapacity(boatCapacity);
             boatList.get(id).setBoatPrice(boatPrice);
              boatList.get(id).setBoatType(boatType);
    }

    /**
     * asks the user for boat id to delete, if there is a boat with such an id,
     * it will be deleted if the boat list is empty nothing will be done
     */
    public static void deleteBoat() throws Exception {
        if (boatList.size() == 0) {
            throw new Exception("Currently no boats in the list! \n Please add a new boat! ");
        } else {
            Integer ID = validateIDFromBoatList("Please, select the ID for the boat you wish to delete:");
            if (ID == null) {
                return;
            }

            int size = boatList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (boatList.get(i).getBoatID() == ID) {
                    boatList.remove(i);
                    System.out.println("You deleted successfully. ");
                }
            }
        }
        returnToSubMenu();
    }
    
    /**
     * receive id as a parameter, if there is a boat with such an id,
     * it will be deleted if the boat list is empty nothing will be done
     */
     public static void deleteBoat(int id) {
            int size = boatList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (boatList.get(i).getBoatID() == id) {
                    boatList.remove(i);
                }
            }
    }

    /**
     * all created boats in the list will be displayed on the console
     */
    public static void listBoats() {
        if (boatList.size() == 0) {
            System.out.println("Currently no boats in the list! \n Please add a new boat! ");
        } else {
            System.out.println("Boats currently in the list are:");
            for (Boat boat : boatList) {
                System.out.println(boat.toString());
            }
        }
        returnToSubMenu();
    }

    /**
     * checks whether there is a boat in the list with the same id
     *
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
            throw new NoSuchElementException("Boat with this id doesn't exist!");
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            returnToSubMenu();
            return null;
        } catch (Exception e) {
            System.out.println("Invalid input! Try again. ");
            returnToSubMenu();
            return null;
        }
    }
    /**
     * check if there is a boat with the id, which is received as a parameter
     * 
     */
     public static boolean existingID(int id) {
            for (int i = 0; i < boatList.size(); i++) {
                if (boatList.get(i).getBoatID() == id) {
                    return true;
                }}
            return false;
    }
     /**
     * check if there is a boat with the id, which is received as a parameter
     * if there is boat with this id, the method returns it
     * else return null
     */
      public static Boat findBoat(int id) {
            for (int i = 0; i < boatList.size(); i++) {
                if (boatList.get(i).getBoatID() == id) {
                    return boatList.get(i);
                }}
            return null;
    }
    
    /**
     * asks the user to enter a specific attribute searches for boat that have a
     * particular characteristic, such as type, price, capacity all boats owning
     * this attribute will be displayed
     */
    public static void searchBoat() {
        System.out.print("\nEnter an attribute for searching: ");
        String attribute = scanner.nextLine();
        List<Boat> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < boatList.size(); i++) {
            if (String.valueOf(boatList.get(i).getBoatID()).equals(attribute)
                    || String.valueOf(boatList.get(i).getBoatCapacity()).equals(attribute)
                    || String.valueOf(boatList.get(i).getBoatPrice()).equals(attribute)
                    || boatList.get(i).getBoatType().equals(attribute)) {
                isFound = true;
                list.add(boatList.get(i));
            }
        }
        if (!isFound) {
            System.out.println("No element is found.");
        } else {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        returnToSubMenu();
    }

    /**
     * here i create and add to the boat list three test boats as far as
     * understood according to the testat
     */
    public static void create3TestBoats() {
        Boat boat1 = new Boat("little boat", 4, 1000);
        Boat boat2 = new Boat("big boat", 10, 2500);
        Boat boat3 = new Boat("bigger boat", 20, 5000);
        boatList.add(boat1);
        boatList.add(boat2);
        boatList.add(boat3);
    }
}
