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

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 *
 * @author danie
 */
public class TouristManager {

    private static ArrayList<Tourist> touristList = new ArrayList<>();

    public static void addTourist() {
        Tourist newTourist= validateTouristInput(touristList);
        if (newTourist == null){
            return;
        }
        touristList.add(newTourist);
        System.out.println(ADDED_MESSAGE + newTourist.toString());
        returnToSubMenu();
    }

    public static void updateTourist() {
        if (touristList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_TOURIST_IN_THE_LIST);
            for (Tourist tourist : touristList) {
                System.out.println(tourist.toString());
            }
            int ID = validateIdInTouristList(touristList,TOURIST_TO_UPDATE);

            for (Tourist tourist:touristList) {
                if (tourist.getTouristID()==ID){
                    tourist.updateTourist();
                }
            }

           /* System.out.print("Enter the new ID: ");
            int newID = ManagerInput.validateIntegerInput();
            System.out.print("Enter the new tourist name: ");
            String newName = input.nextLine();
            boolean touristLicense;
            if (inputManager.getTouristLicenseInput() == true) {
                touristLicense = true;
            } else {
                touristLicense = false;
            }
            int touristVoucherID = inputManager.getTouristVoucherIDInput();

            int i = 0;
            while (i < this.touristList.size()) {
                Tourist currentTourist = this.touristList.get(i);
                int currentID = currentTourist.getTouristID();
                if (currentID == oldID) {
                    currentTourist.setTouristID(newID);
                    currentTourist.setTouristName(newName);
                    currentTourist.setBoatDrivingLicense(touristLicense);
                    currentTourist.setVoucherID(touristVoucherID);
                }
                ++i;
            }*/
        } returnToSubMenu();
    }

    public static void deleteTourist() {
        if (touristList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_TOURIST_IN_THE_LIST);
            for (Tourist tourist : touristList) {
                System.out.println(tourist.toString());
            }
            int givenID = validateIdInTouristList(touristList,TOURIST_ID_FOR_DELETE);

            int size = touristList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (touristList.get(i).getTouristID()==givenID){
                    touristList.remove(i);
                }
            }
           /* int i = 0;
            while (i < this.touristList.size()) {
                Tourist currentTourist = this.touristList.get(i);
                int currentID = currentTourist.getTouristID();

                if (currentID == givenID) {
                    this.touristList.remove(i);
                }
                ++i;
            }*/
        } returnToSubMenu();
    }

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

    public static Integer validateIDFromTouristList(String str){
        do {
            try {
                System.out.println(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < touristList.size(); i++) {
                    if (touristList.get(i).getTouristID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_TOURIST_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        } while (true);
    }

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
