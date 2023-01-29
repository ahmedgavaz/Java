package Non_Simple_Version.Objects;

import static Non_Simple_Version.Management.BoatManager.validateIDFromBoatList;
import static Non_Simple_Version.Management.EmployeeManager.validateIDFromEmployeeList;
import static Non_Simple_Version.ValidatorsAndMessages.*;

public class MaintenanceAndRepair {
    private static int count =1;
    private int maintenanceAndRepairID;
    private int boatID;
    private int employeeID;
    private String typeOfRepair;

    public MaintenanceAndRepair(int boatID, int employeeID, String typeOfRepair) {
        this.maintenanceAndRepairID = count;
        this.boatID = boatID;
        this.employeeID = employeeID;
        this.typeOfRepair = typeOfRepair;
        count++;
    }

    @Override
    public String toString() {
        return "MaintenanceAndRepair:\n" +
                "BoatID: " + boatID +
                "\nEmployeeID: " + employeeID +
                "\nTypeOfRepair: " + typeOfRepair+"\n";
    }

    public int getMaintenanceAndRepairID() {
        return maintenanceAndRepairID;
    }

    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    public int getBoatID() {
        return boatID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getTypeOfRepair() {
        return typeOfRepair;
    }

    public void setTypeOfRepair(String typeOfRepair) {
        this.typeOfRepair = typeOfRepair;
    }
    public static MaintenanceAndRepair createMaintenanceAndRepair(){
        Integer boatID = validateIDFromBoatList(ENTER_MAINTENANCE_BOAT_ID);
        if (boatID==null){
            return null;
        }
        Integer employeeID =  validateIDFromEmployeeList(ENTER_MAINTENANCE_EMPLOYEE_ID);
        if (employeeID==null){
            return null;
        }
        String typeOfRepair = validateStringInput(ENTER_MAINTENANCE_TYPE_OF_REPAIR);
        return new MaintenanceAndRepair(boatID,employeeID,typeOfRepair);
    }
    public void updateMaintenanceAndRepair(){
        Integer boatID = validateIDFromBoatList(ENTER_MAINTENANCE_BOAT_ID);
        if (boatID==null){
            return;
        }
        setBoatID(boatID);
        Integer employeeID =  validateIDFromEmployeeList(ENTER_MAINTENANCE_EMPLOYEE_ID);
        if (employeeID==null){
            return;
        }
        setEmployeeID(employeeID);
        String typeOfRepair = validateStringInput(ENTER_MAINTENANCE_TYPE_OF_REPAIR);
        setTypeOfRepair(typeOfRepair);
    }
}
