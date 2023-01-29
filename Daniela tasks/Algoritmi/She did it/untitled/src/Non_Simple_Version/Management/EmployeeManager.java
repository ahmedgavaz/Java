package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Booking;
import Non_Simple_Version.Objects.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 * deals with the functionalities that the employee menu presents
 * @author Daniela Dolenska
 */
public class EmployeeManager {
    /**
     * array of type Employee that stores all the created employees
     */
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    /**
     * creates and adds another employee in the employee list
     */
    public static void addEmployee() {
        Employee employee = Employee.createEmployee();
        employeeList.add(employee);
        System.out.println(ADDED_MESSAGE + employee.toString());
        returnToSubMenu();
    }

    /**
     * asks user for employee id to update, and if there is such an id in the list, it will be updated
     * if the employee list is empty nothing will be done
     */
    public static void updateEmployee() {
        if (employeeList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            Integer ID =  validateIDFromEmployeeList(EMPLOYEE_ID_FOR_UPDATE);
            if (ID==null){
                return;
            }
            for (Employee employee:employeeList) {
                if (employee.getEmployeeID()==ID){
                    employee.updateEmployee();
                    System.out.println(UPDATE + employee.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for employee id to delete, if there is one  with such an id, it will be deleted
     * if the employee list is empty nothing will be done
     */
    public static void deleteEmployee() {
        if (employeeList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            Integer ID =  validateIDFromEmployeeList(EMPLOYEE_ID_FOR_DELETING);
            if (ID==null){
                return;
            }
            int size = employeeList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (employeeList.get(i).getEmployeeID()==ID){
                    employeeList.remove(i);
                    System.out.println(DELETION);
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created employees in the list will be displayed on the console
     */
    public static void listEmployee() {

        if (employeeList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
        returnToSubMenu();
    }
    public static Integer validateIDFromEmployeeList(String str){
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getEmployeeID() == value) {
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
     * searches for employee that have a particular characteristic, such as employee id, name or job
     * all employees owning this attribute will be displayed
     */
    public static void searchEmployee() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Employee> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (String.valueOf(employeeList.get(i).getEmployeeID()).equals(attribute) ||
                    employeeList.get(i).getEmployeeName().equals(attribute) ||
                    employeeList.get(i).getEmployeeJob().equals(attribute)) {
                isFound = true;
                list.add(employeeList.get(i));
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
