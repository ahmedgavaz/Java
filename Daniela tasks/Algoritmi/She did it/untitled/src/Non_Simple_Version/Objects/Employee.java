package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 *the characteristics of the object employee are defined
 * @author Daniela Dolenska
 */
public class Employee {
    private static int count =1;
    private int employeeID;
    private String employeeName;
    private String employeeJob;

    /**
     * defines how the visualisations of the object employee will be displayed
     * @return the object employee with its parameters
     */
    @Override
    public String toString() {
        return "Employee {"+ "Employee ID: " + employeeID + ", Employee name: " + employeeName + ", Employee job: "+employeeJob +'}';
    }

    private Employee(String employeeName, String employeeJob) {
        this.employeeID = count;
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
        count++;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    /**
     * asks the user to enter employee name and job and then creates an employee object
     * the input of the user is checked for errors
     * @return gives the newly created employee object
     */
    public static Employee createEmployee(){
        String employeeName =  validateStringInput(ENTER_EMPLOYEE_NAME);
        String employeeJob = validateStringInput(ENTER_EMPLOYEE_JOB);
        return new Employee(employeeName,employeeJob);
    }
    
    /**
     * sets the name and the job of the employee, which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateEmployee(){
        String employeeName =  validateStringInput(ENTER_EMPLOYEE_NAME);
        setEmployeeName(employeeName);
        String employeeJob = validateStringInput(ENTER_EMPLOYEE_JOB);
        setEmployeeJob(employeeJob);
    }
}
