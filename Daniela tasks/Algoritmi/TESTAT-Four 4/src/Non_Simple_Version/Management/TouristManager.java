/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Management;
import Non_Simple_Version.Objects.Tourist;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static Non_Simple_Version.Validators.*;

/**
 * deals with the functionalities that the tourist menu presents
 * 
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
        if (newTourist == null) {
            return;
        }
        touristList.add(newTourist);
        System.out.println("You added :\n" + newTourist.toString());
        returnToSubMenu();
    }
    /**
     * creates and adds another tourist in the tourist list
     */
        public static void addTourist(String touristName, boolean boatDrivingLicense,String destination) {
            Tourist tourist = new Tourist(touristName,boatDrivingLicense,destination);
            touristList.add(tourist);
        }
/**
     * gets the list of tourists
     *
     * @return the list of tourists
     */
        public static ArrayList<Tourist> getTourists(){
            return touristList;
        }
    /**
     * asks user for tourist id to update, and if there is such an id in the
     * tourist list, the tourist will be updated if the tourist list is empty
     * nothing will be done
     */

        public static boolean existingID(int id) {
            for (int i = 0; i < touristList.size(); i++) {
                if (touristList.get(i).getTouristID() == id) {
                    return true;
                }}
            return false;
             }
        
        /**
     * receives id as parameter, if there is a tourist with such
     * an id, it will be deleted if the tourist list is empty nothing will be
     * done
     */
        public static void deleteTourist(int id) {
            int size = touristList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (touristList.get(i).getTouristID() == id) {
                    touristList.remove(i);
                }
            }
    }
        /**
     * check if there is a tourist with the id, which is received as a parameter
     * if there is tourist with this id, the method returns it
     * else return null
     */
        public static Tourist findTourist(int id) {
            for (int i = 0; i < touristList.size(); i++) {
                if (touristList.get(i).getTouristID() == id) {
                    return touristList.get(i);
                }}
            return null;
    }
        
            public static void updateTourist(int id,String touristName, boolean drivingLicense, String destination) {
            touristList.get(id).setTouristName(touristName);
             touristList.get(id).setBoatDrivingLicense(drivingLicense);
              touristList.get(id).setDestination(destination);
    }
/**
     * asks user for tourist id to update, and if there is such an id in the
     * touristList, the tourist will be updated if the tourist list is empty nothing will
     * be done
     */
    public static void updateTourist() {
        if (touristList.size() == 0) {
            System.out.println("Currently no tourists in the list! \n Please add a new tourists!");
        } else {
            Integer ID = validateIDFromTouristList("Which tourist ID do you want to update?");
            if (ID == null) {
                return;
            }
            for (Tourist tourist : touristList) {
                if (tourist.getTouristID() == ID) {
                    tourist.updateTourist();
                    System.out.println("You updated successfully: " + tourist.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for tourist id to delete, if there is a tourist with such
     * an id, it will be deleted if the tourist list is empty nothing will be
     * done
     */
    public static void deleteTourist() {
        if (touristList.size() == 0) {
            System.out.println("Currently no tourists in the list! \n Please add a new tourist!");
        } else {
            Integer givenID = validateIDFromTouristList("Please, select the ID for the tourist you wish to delete:");
            if (givenID == null) {
                return;
            }
            int size = touristList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (touristList.get(i).getTouristID() == givenID) {
                    touristList.remove(i);
                    System.out.println("You deleted successfully. ");
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created tourists in the list will be displayed on the console
     */
    public static void listTourists() {

        if (touristList.size() == 0) {
            System.out.println("Currently no tourist in the list! \n Please add a new tourist!");
        } else {
            System.out.println("Tourists currently in the list are:");
            for (Tourist tourist : touristList) {
                System.out.println(tourist.toString());
            }
        }
        returnToSubMenu();
    }

    /**
     * checks whether there is a tourist in the list with the same id
     *
     * @param str output message on the console
     * @return returns the tourist or null if it does not exist
     */
    public static Integer validateIDFromTouristList(String str) {
        try {
            System.out.println(str);
            int value = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < touristList.size(); i++) {
                if (touristList.get(i).getTouristID() == value) {
                    return value;
                }
            }
            throw new NoSuchElementException("Tourist with this id doesn't exist!");
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            returnToSubMenu();
            return null;
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            returnToSubMenu();
            return null;
        }
    }

    /**
     * asks the user to enter a specific attribute searches for tourist that
     * have a particular characteristic, such as tourist id, name, voucher id or
     * presence of driving license all tourists owning this attribute will be
     * displayed
     */
    public static void searchTourist() {
        System.out.print("\nEnter an attribute for searching: ");
        String attribute = scanner.nextLine();
        List<Tourist> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < touristList.size(); i++) {
            if (String.valueOf(touristList.get(i).getTouristID()).equals(attribute)
                    || String.valueOf(touristList.get(i).getVoucherID()).equals(attribute)
                    || touristList.get(i).getTouristName().equals(attribute)
                    || (attribute.equals("true") && touristList.get(i).getBoatDrivingLicense())
                    || (attribute.equals("false") && !touristList.get(i).getBoatDrivingLicense())) {
                isFound = true;
                list.add(touristList.get(i));
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
}
