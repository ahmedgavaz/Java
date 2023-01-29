/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.MaintenanceAndRepair;
import Non_Simple_Version.Objects.Tourist;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 * deals with the functionalities that the tourist menu presents
 * @author Daniela Dolenska
 */
public class TouristManager {
    /**
     * array of type Tourist that stores all the created tourists
     */
    private static ArrayList<Tourist> touristList = new ArrayList<>();

    /**
     * creates and adds another tourist in the tourist list
     */
    public static void addTourist() {
        Tourist newTourist = Tourist.createTourist();
        if (newTourist == null){
        returnToSubMenu();   
            return;
        }
        touristList.add(newTourist);
        System.out.println(ADDED_MESSAGE + newTourist.toString());
        returnToSubMenu();
    }

    /**
     * asks user for tourist id to update, and if there is such an id in the tourist list, the tourist will be updated
     * if the tourist list is empty nothing will be done
     */
    public static void updateTourist() {
        if (touristList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromTouristList(TOURIST_TO_UPDATE);
            if (ID == null){
                return;
            }
            for (Tourist tourist:touristList) {
                if (tourist.getTouristID()==ID){
                    tourist.updateTourist();
                    System.out.println(UPDATE + tourist.toString());
                }
            }
        } returnToSubMenu();
    }

    /**
     * asks the user for tourist id to delete, if there is a tourist with such an id, it will be deleted
     * if the tourist list is empty nothing will be done
     */
    public static void deleteTourist() {
        if (touristList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            Integer givenID = validateIDFromTouristList(TOURIST_ID_FOR_DELETE);
            if (givenID == null){
                return;
            }
            int size = touristList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (touristList.get(i).getTouristID()==givenID){
                    touristList.remove(i);
                    System.out.println(DELETION);
                }
            }
        } returnToSubMenu();
    }

    /**
     * all created tourists in the list will be displayed on the console
     */
    public static void listTourists() {

        if (touristList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_TOURIST_IN_THE_LIST);
            for (Tourist tourist : touristList) {
                System.out.println(tourist.toString());
            }
        } returnToSubMenu();
    }

    /**
     * checks whether there is a tourist in the list with the same id
     * @param str output message on the console
     * @return returns the tourist or null if it does not exist
     */
    public static Integer validateIDFromTouristList(String str){
            try {
                System.out.println(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < touristList.size(); i++) {
                    if (touristList.get(i).getTouristID() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_TOURIST_WITH_THIS_ID);
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
     * searches for tourist that have a particular characteristic, such as tourist id, name, voucher id or presence of driving license
     * all tourists owning this attribute will be displayed
     */
    public static void searchTourist() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Tourist> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < touristList.size(); i++) {
            if (String.valueOf(touristList.get(i).getTouristID()).equals(attribute) ||
                    String.valueOf(touristList.get(i).getVoucherID()).equals(attribute) ||
                    touristList.get(i).getTouristName().equals(attribute) ||
                    (attribute.equals("true") && touristList.get(i).isBoatDrivingLicense()) ||
                    (attribute.equals("false") && !touristList.get(i).isBoatDrivingLicense()) ) {
                isFound = true;
                list.add(touristList.get(i));
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
