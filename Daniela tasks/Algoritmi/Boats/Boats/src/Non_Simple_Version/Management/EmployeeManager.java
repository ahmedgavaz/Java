package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;

public class EmployeeManager {
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void addEmployee() {
        Employee employee = validateEmployeeInput(employeeList);
        employeeList.add(employee);
        System.out.println(ADDED_MESSAGE + employee.toString());
        returnToSubMenu();
    }

    public static void updateEmployee() {
        if (employeeList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
            int ID = validateIdInEmployeeList(employeeList,EMPLOYEE_ID_FOR_UPDATE);

            for (Employee employee:employeeList) {
                if (employee.getEmployeeID()==ID){
                    employee.updateEmployee();
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

    public static void deleteEmployee() {
        if (employeeList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
            int givenID = validateIdInEmployeeList(employeeList,EMPLOYEE_ID_FOR_DELETING);

            int size = employeeList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (employeeList.get(i).getEmployeeID()==givenID){
                    employeeList.remove(i);
                }
            }
        }
        returnToSubMenu();
    }

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
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getEmployeeID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EMPLOYEE_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        } while (true);
    }
    public static void searchEmployee() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Employee> list = new ArrayList<>();
        int type = typeOfAttribute(attribute);
        int integerAttribute;
        boolean isFound = false;
        //if the attribute is integer we look in every element which is integer
        if (type == 1) {
            integerAttribute = Integer.parseInt(attribute);
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeID() == integerAttribute) {
                    isFound = true;
                    list.add(employeeList.get(i));
                }
            }
        } //if the attribute is string we look in every element which is string
        else {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeJob().equals(attribute) || employeeList.get(i).getEmployeeName().equals(attribute)) {
                    isFound = true;
                    list.add(employeeList.get(i));
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
