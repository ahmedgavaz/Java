package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;

public class Employee {
    private static int count =1;
    private int employeeID;
    private String employeeName;
    private String employeeJob;

    @Override
    public String toString() {
        return "EmployeeID: " + employeeID + "\nEmployeeName: " + employeeName + "\nEmployeeJob: " + employeeJob+"\n";
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

    public static Employee createEmployee(){
        String employeeName =  validateStringInput(ENTER_EMPLOYEE_NAME);
        String employeeJob = validateStringInput(ENTER_EMPLOYEE_JOB);
        return new Employee(employeeName,employeeJob);
    }
    public void updateEmployee(){
        String employeeName =  validateStringInput(ENTER_EMPLOYEE_NAME);
        setEmployeeName(employeeName);
        String employeeJob = validateStringInput(ENTER_EMPLOYEE_JOB);
        setEmployeeJob(employeeJob);
    }
}
