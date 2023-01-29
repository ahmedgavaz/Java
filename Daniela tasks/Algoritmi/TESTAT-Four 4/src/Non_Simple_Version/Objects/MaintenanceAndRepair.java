package Non_Simple_Version.Objects;

import static Non_Simple_Version.Management.BoatManager.validateIDFromBoatList;
import static Non_Simple_Version.Management.EmployeeManager.validateIDFromEmployeeList;
import static Non_Simple_Version.Validators.*;

/**
 * the characteristics of the object maintenanceAndrepair are defined. In order
 * for this class to function properly first employees and boats should be
 * created, because they are elements of one maintenance.
 *
 * @author Daniela Dolenska
 */
public class MaintenanceAndRepair {

    private static int count = 1;
    private int maintenanceAndRepairID;
    private int boatID;
    private int employeeID;
    private String typeOfRepair;

    /**
     * constructor that creates an instance of the class
     *
     * @param boatID characteristic of the object - boat id
     * @param employeeID characteristic of the object - employee id
     * @param typeOfRepair characteristic of the object - type of repair
     */
    public MaintenanceAndRepair(int boatID, int employeeID, String typeOfRepair) {
        this.maintenanceAndRepairID = count;
        this.boatID = boatID;
        this.employeeID = employeeID;
        this.typeOfRepair = typeOfRepair;
        count++;
    }

    /**
     * defines how the visualisations of the object maintenance will be
     * displayed
     *
     * @return the object maintenance with its parameters
     */
    @Override
    public String toString() {
        return "MaintenanceAndRepair {" + "Boat ID: " + boatID + ", Employee ID: " + employeeID + ", Type of repair: " + typeOfRepair + '}';
    }

    /**
     * gets the id of the maintenance
     *
     * @return the id of the maintenance
     */
    public int getMaintenanceAndRepairID() {
        return maintenanceAndRepairID;
    }

    /**
     * sets the new boat id
     *
     * @param boatID the new boat id
     */
    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    /**
     * gets the boat id
     *
     * @return the boat id
     */
    public int getBoatID() {
        return boatID;
    }

    /**
     * gets the employee id
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * sets the new the employee id
     *
     * @param employeeID the new the employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * gets the type of the repair
     *
     * @return the type of the repair
     */
    public String getTypeOfRepair() {
        return typeOfRepair;
    }

    /**
     * sets the new type of the repair
     *
     * @param typeOfRepair the new type of the repair
     */
    public void setTypeOfRepair(String typeOfRepair) {
        this.typeOfRepair = typeOfRepair;
    }

    /**
     * asks the user to enter boat id, employee id and type of repair and then
     * creates a maintenance object the input of the user is checked for errors
     *
     * @return gives the newly created maintenance object
     */
    public static MaintenanceAndRepair createMaintenanceAndRepair() {
        Integer boatID = validateIDFromBoatList("Enter maintenance and repair boat id: ");
        if (boatID == null) {
            return null;
        }
        Integer employeeID = validateIDFromEmployeeList("Enter maintenance and repair employee id: ");
        if (employeeID == null) {
            return null;
        }
        String typeOfRepair = validateStringInput("Enter maintenance type of repair: ");
        return new MaintenanceAndRepair(boatID, employeeID, typeOfRepair);
    }

    /**
     * sets the boatID, employeeID and type of repair, which the user wants to
     * update the input of the user is checked for errors
     */
    public void updateMaintenanceAndRepair() {
        Integer boatID = validateIDFromBoatList("Enter maintenance and repair boat id: ");
        if (boatID == null) {
            return;
        }
        setBoatID(boatID);
        Integer employeeID = validateIDFromEmployeeList("Enter maintenance and repair employee id: ");
        if (employeeID == null) {
            return;
        }
        setEmployeeID(employeeID);
        String typeOfRepair = validateStringInput("Enter maintenance type of repair: ");
        setTypeOfRepair(typeOfRepair);
    }
}
