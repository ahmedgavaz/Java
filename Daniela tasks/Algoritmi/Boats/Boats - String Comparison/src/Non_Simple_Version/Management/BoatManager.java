/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 * @author danie
 */
public class BoatManager {

    private static ArrayList<Boat> boatList = new ArrayList<>();

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }

    public static void addBoat() {
        Boat newBoat = validateBoatInput(boatList);
        boatList.add(newBoat);
        System.out.println(ADDED_MESSAGE + newBoat.toString());
        returnToSubMenu();
    }

    public static void updateBoat() {
        if (boatList.size() == 0) {
            System.out.println(NO_BOATS_IN_THE_LIST);
        } else {
            System.out.println(BOATS_BY_ID);
            for (Boat boat : boatList) {
                System.out.println(boat.toString());
            }
            int ID = validateIdInBoatList(boatList, BOATS_ID_FOR_UPDATE);

            for (Boat boat : boatList) {
                if (boat.getBoatID() == ID) {
                    boat.updateBoat();
                }
            }

         /*   int i = 0;
            while (i < this.boatList.size()) {
                Boat currentBoat = this.boatList.get(i);
                int currentID = currentBoat.getBoatID();

                if (currentID == oldID) {
                    currentBoat.setBoatID(newID);
                    currentBoat.setBoatType(newBoatType);
                    currentBoat.setBoatPrice(newPrice);
                }
                ++i;
            }*/
        }
        returnToSubMenu();
    }

    public static void deleteBoat() {
        if (boatList.size() == 0) {
            System.out.println(NO_BOATS_IN_THE_LIST);
        } else {
            System.out.println(BOATS_BY_ID);
            for (Boat boat : boatList) {
                System.out.println(boat.toString());
            }
            int givenID = validateIdInBoatList(boatList, BOAT_ID_FOR_DELETING);

            int size = boatList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (boatList.get(i).getBoatID() == givenID) {
                    boatList.remove(i);
                }
            }
        }
        returnToSubMenu();
    }

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

    public static Integer validateIDFromBoatList(String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < boatList.size(); i++) {
                    if (boatList.get(i).getBoatID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_BOAT_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        } while (true);
    }

    public static void searchBoat() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Boat> list = new ArrayList<>();
        boolean isFound = false;
            for (int i = 0; i < boatList.size(); i++) {
                if (String.valueOf(boatList.get(i).getBoatID()).equals(attribute) ||
                        String.valueOf(boatList.get(i).getBoatPrice()).equals(attribute) ||
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
        }
    }
}
