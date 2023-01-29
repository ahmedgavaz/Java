package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Booking;
import Non_Simple_Version.Objects.MaintenanceAndRepair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

public class MaintenanceAndRepairManager {
    private static ArrayList<MaintenanceAndRepair> maintenanceList = new ArrayList<>();

    public static void addMaintenance() {
        MaintenanceAndRepair maintenanceAndRepair = validateMaintenanceInput(maintenanceList);
        if (maintenanceAndRepair==null){
            return;
        }
        maintenanceList.add(maintenanceAndRepair);
        System.out.println(ADDED_MESSAGE + maintenanceAndRepair.toString());
        returnToSubMenu();
    }

    public static void updateMaintenance() {
        if (maintenanceList.size() == 0) {
            System.out.println(NO_MAINTENANCE_IN_THE_LIST);
        } else {
            System.out.println(MAINTENANCES_BY_ID);
            for (MaintenanceAndRepair maintenanceAndRepair : maintenanceList) {
                System.out.println(maintenanceAndRepair.toString());
            }
            int ID = validateIdInMaintenanceList(maintenanceList,MAINTENANCE_ID_FOR_UPDATE);

            for (MaintenanceAndRepair maintenanceAndRepair:maintenanceList) {
                if (maintenanceAndRepair.getMaintenanceAndRepairID()==ID){
                    maintenanceAndRepair.updateMaintenanceAndRepair();
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

    public static void deleteMaintenance() {
        if (maintenanceList.size() == 0) {
            System.out.println(NO_MAINTENANCE_IN_THE_LIST);
        } else {
            System.out.println(MAINTENANCES_BY_ID);
            for (MaintenanceAndRepair maintenanceAndRepair : maintenanceList) {
                System.out.println(maintenanceAndRepair.toString());
            }
            int givenID = validateIdInMaintenanceList(maintenanceList,MAINTENANCE_ID_FOR_DELETING);

            int size = maintenanceList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (maintenanceList.get(i).getMaintenanceAndRepairID()==givenID){
                    maintenanceList.remove(i);
                }
            }
        }
        returnToSubMenu();
    }

    public static void listMaintenance() {
        if (maintenanceList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (MaintenanceAndRepair maintenanceAndRepair : maintenanceList) {
                System.out.println(maintenanceAndRepair.toString());
            }
        }
        returnToSubMenu();
    }
    public static void searchMaintenance() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<MaintenanceAndRepair> list = new ArrayList<>();
        int type = typeOfAttribute(attribute);
        int integerAttribute;
        boolean isFound = false;
        //if the attribute is integer we look in every element which is integer
        if (type == 1) {
            integerAttribute = Integer.parseInt(attribute);
            for (int i = 0; i < maintenanceList.size(); i++) {
                if (maintenanceList.get(i).getBoatID() == integerAttribute || maintenanceList.get(i).getEmployeeID()==integerAttribute ||
                maintenanceList.get(i).getMaintenanceAndRepairID()==integerAttribute) {
                    isFound = true;
                    list.add(maintenanceList.get(i));
                }
            }
        } //if the attribute is string we look in every element which is string
        else {
            for (int i = 0; i < maintenanceList.size(); i++) {
                if (maintenanceList.get(i).getTypeOfRepair().equals(attribute)) {
                    isFound = true;
                    list.add(maintenanceList.get(i));
                }
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
