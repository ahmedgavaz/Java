package Non_Simple_Version.Objects;

import static Non_Simple_Version.Validators.*;

/**
 * the characteristics of the object employee are defined
 *
 * @author Daniela Dolenska
 */
public class Employee {

    private static int count = 1;
    private int employeeID;
    private String employeeName;
    private String employeeJob;

    /**
     * defines how the visualisations of the object employee will be displayed
     *
     * @return the object employee with its parameters
     */
    @Override
    public String toString() {
        return "Employee {" + "Employee ID: " + employeeID + ", Employee name: " + employeeName + ", Employee job: " + employeeJob + '}';
    }

    /**
     * constructor that creates an instance of the class
     *
     * @param employeeName name of the employee object
     * @param employeeJob job of the employee object
     */
    private Employee(String employeeName, String employeeJob) {
        this.employeeID = count;
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
        count++;
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
     * gets the name of the employee
     *
     * @return the name of the employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * sets the new name of the employee
     *
     * @param employeeName the new name of the employee
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * gets the job of the employee
     *
     * @return the job of the employee
     */
    public String getEmployeeJob() {
        return employeeJob;
    }

    /**
     * sets the new job of the employee
     *
     * @param employeeJob the new job of the employee
     */
    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    /**
     * asks the user to enter employee name and job and then creates an employee
     * object the input of the user is checked for errors
     *
     * @return gives the newly created employee object
     */
    public static Employee createEmployee() {
        String employeeName = validateStringInput("Enter employee name: ");
        String employeeJob = validateStringInput("Enter employee job: ");
        return new Employee(employeeName, employeeJob);
    }

    /**
     * sets the name and the job of the employee, which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateEmployee() {
        String employeeName = validateStringInput("Enter employee name: ");
        setEmployeeName(employeeName);
        String employeeJob = validateStringInput("Enter employee job: ");
        setEmployeeJob(employeeJob);
    }
}
