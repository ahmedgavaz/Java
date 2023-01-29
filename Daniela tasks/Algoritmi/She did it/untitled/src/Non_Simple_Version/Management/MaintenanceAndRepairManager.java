package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.MaintenanceAndRepair;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

/**
 * deals with the functionalities that the maintenance menu presents
 * @author Daniela Dolenska
 */
public class MaintenanceAndRepairManager {
    /**
     * array of type MaintenanceAndRepair that stores all the created maintenance
     */
    private static ArrayList<MaintenanceAndRepair> maintenanceList = new ArrayList<>();

    /**
     * creates and adds another maintenance in the list
     */
    public static void addMaintenance() {
        MaintenanceAndRepair maintenanceAndRepair = MaintenanceAndRepair.createMaintenanceAndRepair();
        if (maintenanceAndRepair==null){
            return;
        }
        maintenanceList.add(maintenanceAndRepair);
        System.out.println(ADDED_MESSAGE + maintenanceAndRepair.toString());
        returnToSubMenu();
    }

    /**
     * asks user for maintenance id to update, and if there is such an id in the list, it will be updated
     * if the maintenance list is empty nothing will be done
     */
    public static void updateMaintenance() {
        if (maintenanceList.size() == 0) {
            System.out.println(NO_MAINTENANCE_IN_THE_LIST);
        } else {
            Integer ID = validateIdFromMaintenanceList(MAINTENANCE_ID_FOR_UPDATE);
            if (ID == null){
                return;
            }
            for (MaintenanceAndRepair maintenanceAndRepair:maintenanceList) {
                if (maintenanceAndRepair.getMaintenanceAndRepairID()==ID){
                    maintenanceAndRepair.updateMaintenanceAndRepair();
                    System.out.println(UPDATE + maintenanceAndRepair.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for maintenance id to delete, if there is one  with such an id, it will be deleted
     * if the maintenance list is empty nothing will be done
     */
    public static void deleteMaintenance() {
        if (maintenanceList.size() == 0) {
            System.out.println(NO_MAINTENANCE_IN_THE_LIST);
        } else {
            Integer ID = validateIdFromMaintenanceList(MAINTENANCE_ID_FOR_DELETING);
            if (ID == null){
                return;
            }

            int size = maintenanceList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (maintenanceList.get(i).getMaintenanceAndRepairID()==ID){
                    maintenanceList.remove(i);
                    System.out.println(DELETION);
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created maintenance in the list will be displayed on the console
     */
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


    public static Integer validateIdFromMaintenanceList(String str) {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < maintenanceList.size(); i++) {
                    if (maintenanceList.get(i).getMaintenanceAndRepairID() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_EMPLOYEE_WITH_THIS_ID);
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
     * searches for maintenance that have a particular characteristic, such as id, employee id, boat id or repair type
     * all maintenance owning this attribute will be displayed
     */
    public static void searchMaintenance() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<MaintenanceAndRepair> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < maintenanceList.size(); i++) {
            if (String.valueOf(maintenanceList.get(i).getBoatID()).equals(attribute) ||
                    String.valueOf(maintenanceList.get(i).getEmployeeID()).equals(attribute) ||
                    String.valueOf(maintenanceList.get(i).getMaintenanceAndRepairID()).equals(attribute) ||
                    maintenanceList.get(i).getTypeOfRepair().equals(attribute)) {
                isFound = true;
                list.add(maintenanceList.get(i));
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
}
