package Non_Simple_Version;

import Non_Simple_Version.Objects.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ValidatorsAndMessages {
    ;
    public static Scanner scanner = new Scanner(System.in);
    public static final String ENTER_BOAT_TYPE = "Enter boat type: ";
    public static final String ENTER_BOAT_PRICE = "Enter boat price: ";
    public static final String ADDED_MESSAGE = "You added :\n";
    public static final String NO_BOATS_IN_THE_LIST = "Currently no boats in the list! \n Please add a new boat!";
    public static final String BOATS_BY_ID = "Boats currently in list by their respective ID are:";
    public static final String EMPLOYEES_BY_ID = "Employees currently in list by their respective ID are:";
    public static final String EXTRAS_BY_ID = "Extras currently in list by their respective ID are:";
    public static final String VOUCHERS_BY_ID = "Vouchers currently in list by their respective ID are:";
    public static final String MAINTENANCES_BY_ID = "Maintenances and repairs currently in list by their respective ID are:";
    public static final String BOATS_ID_FOR_UPDATE = "Which boat ID do you want to update?";
    public static final String EMPLOYEE_ID_FOR_UPDATE = "Which employee ID do you want to update?";
    public static final String EXTRA_ID_FOR_UPDATE = "Which extra ID do you want to update?";
    public static final String VOUCHER_ID_FOR_UPDATE = "Which voucher ID do you want to update?";
    public static final String MAINTENANCE_ID_FOR_UPDATE = "Which maintenance or repair ID do you want to update?";
    public static final String BOAT_WITH_THIS_ID_EXIST = "Boat with this id already exist!";
    public static final String TOURIST_WITH_THIS_ID_EXIST = "Tourist with this id already exist!";
    public static final String EMPLOYEE_WITH_THIS_ID_EXIST = "Employee with this id already exist!";
    public static final String EXTRA_WITH_THIS_ID_EXIST = "Extra with this id already exist!";
    public static final String MAINTENANCE_WITH_THIS_ID_EXIST = "Maintenance with this id already exist!";
    public static final String NO_BOAT_WITH_THIS_ID = "Boat with this id doesn't exist!";
    public static final String NO_TOURIST_WITH_THIS_ID = "Tourist with this id doesn't exist!";
    public static final String NO_VOUCHER_WITH_THIS_ID = "Voucher with this id doesn't exist!";
    public static final String NO_EMPLOYEE_WITH_THIS_ID = "Employee with this id doesn't exist!";
    public static final String NO_EXTRA_WITH_THIS_ID = "Extra with this id doesn't exist!";
    public static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again. ";
    public static final String PARSE_ERROR_MESSAGE = "You should input a number bigger than 0!";
    public static final String TO_SUBMENU = "Press ENTER to return to sub menu ";
    public static final String BOAT_ID_FOR_DELETING = "Please, select the ID for the boat you wish to delete:";
    public static final String EMPLOYEE_ID_FOR_DELETING = "Please, select the ID for the employee you wish to delete:";
    public static final String EXTRA_ID_FOR_DELETING = "Please, select the ID for the extra you wish to delete:";
    public static final String VOUCHER_ID_FOR_DELETING = "Please, select the ID for the voucher you wish to delete:";
    public static final String MAINTENANCE_ID_FOR_DELETING = "Please, select the ID for the maintenance or repair you wish to delete:";
    public static final String BOATS_IN_THE_LIST = "Boats currently in the list are:";
    public static final String NO_TOURIST_IN_THE_LIST = "Currently no tourists in the list!\nPlease add a new tourist!";
    public static final String NO_BOOKINGS_IN_THE_LIST = "Currently no bookings in the list!\nPlease add a new booking!";
    public static final String CURRENTLY_TOURIST_IN_THE_LIST = "Tourists currently in the list are:";
    public static final String CURRENTLY_BOOKINGS_IN_THE_LIST = "Bookings currently in the list are:";
    public static final String ENTER_TOURIST_NAME = "Enter tourist name: ";
    public static final String DOES_TOURIST_HAVE_DRIVING_LICENSE = "Does the tourist have a boat license? Enter Y/N: ";
    public static final String TOURIST_TO_UPDATE = "Which tourist ID do you want to update? ";
    public static final String BOOKING_TO_UPDATE = "Which booking ID do you want to update? ";
    public static final String ENTER_TOURIST_VOUCHER = "Enter tourist voucher ID: ";
    public static final String TOURIST_ID_FOR_DELETE = "Please, select the ID for the tourist you wish to delete:";
    public static final String BOOKING_ID_FOR_DELETE = "Please, select the ID for the booking you wish to delete:";
    public static final String ENTER_EMPLOYEE_NAME = "Enter employee name: ";
    public static final String ENTER_EXTRA_TYPE = "Enter extra type: ";
    public static final String ENTER_VOUCHER_TYPE = "Enter voucher type: ";
    public static final String ENTER_BOOKING_BOAT_ID = "Enter booking boat id: ";
    public static final String ENTER_BOOKING_TOURIST_ID = "Enter booking tourist id: ";
    public static final String ENTER_BOOKING_EXTRA_ID = "Enter booking extra id: ";
    public static final String ENTER_MAINTENANCE_BOAT_ID = "Enter maintenance and repair boat id: ";
    public static final String ENTER_EMPLOYEE_JOB = "Enter employee job: ";
    public static final String ENTER_EXTRA_PRICE = "Enter extra price: ";
    public static final String ENTER_VOUCHER_PRICE = "Enter voucher price: ";
    public static final String ENTER_VOUCHER_DISCOUNT = "Enter voucher discount: ";
    public static final String ENTER_MAINTENANCE_TYPE_OF_REPAIR = "Enter maintenance type of repair: ";
    public static final String ENTER_MAINTENANCE_EMPLOYEE_ID = "Enter maintenance and repair employee id: ";
    public static final String NO_EMPLOYEES_IN_THE_LIST = "Currently no employees in the list! \n Please add a new employee!";
    public static final String NO_EXTRAS_IN_THE_LIST = "Currently no extras in the list! \n Please add a new extra!";
    public static final String NO_VOUCHERS_IN_THE_LIST = "Currently no vouchers in the list! \n Please add a new voucher!";
    public static final String NO_MAINTENANCE_IN_THE_LIST = "Currently no maintenances and repairs in the list! \n Please add a maintenance or repair!";
    public static final String INPUT_ATTRIBUTE = "\nEnter an attribute for searching: ";
    public static final String NO_ELEMENT_FOUND = "No element is found.";
    public static final String ASK_FOR_TYPE_OD_VISUALISATION = "Choose tho correct option for visualisation(1 or 2):";
    public static final String SHOW_ALL_ELEMENTS = "1.Show all elements.";
    public static final String SEARCH_BY_ATTRIBUTE = "2.Search elements by attribute.";
    public static String validateStringInput(String str) {
        do {
            try {
                System.out.print(str);
                String value = scanner.nextLine();
                if (value.length() > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                System.out.print(INVALID_INPUT_MESSAGE);
            }
        } while (true);
    }

    //Same as the method above but checks and returns type double.
    public static double validateDoubleInput(String str) {
        do {
            try {
                System.out.print(str);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (NumberFormatException n) {
                System.out.println(PARSE_ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Boat validateBoatInput(List<Boat> list) {
        do {
            try {
                Boat newBoat = Boat.createBoat();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getBoatID() == newBoat.getBoatID()) {
                        throw new IllegalArgumentException(BOAT_WITH_THIS_ID_EXIST);
                    }
                }
                return newBoat;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Employee validateEmployeeInput(List<Employee> list) {
        do {
            try {
                Employee employee = Employee.createEmployee();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getEmployeeID() == employee.getEmployeeID()) {
                        throw new IllegalArgumentException(EMPLOYEE_WITH_THIS_ID_EXIST);
                    }
                }
                return employee;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Extra validateExtraInput(List<Extra> list) {
        do {
            try {
                Extra extra = Extra.createExtra();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getExtraID() == extra.getExtraID()) {
                        throw new IllegalArgumentException(EXTRA_WITH_THIS_ID_EXIST);
                    }
                }
                return extra;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Voucher validateVoucherInput(List<Voucher> list) {
        do {
            try {
                Voucher voucher = Voucher.createVoucher();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getVoucherId() == voucher.getVoucherId()) {
                        throw new IllegalArgumentException(EXTRA_WITH_THIS_ID_EXIST);
                    }
                }
                return voucher;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static MaintenanceAndRepair validateMaintenanceInput(List<MaintenanceAndRepair> list) {
        do {
            try {
                MaintenanceAndRepair maintenanceAndRepair = MaintenanceAndRepair.createMaintenanceAndRepair();
                if (maintenanceAndRepair == null) {
                    return null;
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getMaintenanceAndRepairID() == maintenanceAndRepair.getMaintenanceAndRepairID()) {
                        throw new IllegalArgumentException(MAINTENANCE_WITH_THIS_ID_EXIST);
                    }
                }
                return maintenanceAndRepair;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Tourist validateTouristInput(List<Tourist> list) {
        do {
            try {
                Tourist tourist = Tourist.createTourist();
                if (tourist == null) {
                    return null;
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getTouristID() == tourist.getTouristID()) {
                        throw new IllegalArgumentException(TOURIST_WITH_THIS_ID_EXIST);
                    }
                }
                return tourist;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Booking validateBookingInput(List<Booking> list) {
        do {
            try {
                Booking booking = Booking.createBooking();
                if (booking == null) {
                    return null;
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getTouristID() == booking.getTouristID()) {
                        throw new IllegalArgumentException(TOURIST_WITH_THIS_ID_EXIST);
                    }
                }
                return booking;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInBoatList(List<Boat> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getBoatID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_BOAT_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInEmployeeList(List<Employee> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getEmployeeID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EMPLOYEE_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInExtraList(List<Extra> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getExtraID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EMPLOYEE_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInVoucherList(List<Voucher> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getVoucherId() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EMPLOYEE_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInMaintenanceList(List<MaintenanceAndRepair> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getMaintenanceAndRepairID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EMPLOYEE_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInTouristList(List<Tourist> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getTouristID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_TOURIST_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static int validateIdInBookingList(List<Booking> list, String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getBookingID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_TOURIST_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void returnToSubMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(TO_SUBMENU);
        keyboard.nextLine();
    }

    public static boolean validateDrivingLicenseInput(String str) {
        do {
            try {
                System.out.print(str);
                String value = scanner.nextLine().trim().toUpperCase();
                if (value.equals("Y")) {
                    return true;
                } else if (value.equals("N")) {
                    return false;
                } else {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                System.out.print(INVALID_INPUT_MESSAGE);
            }
        } while (true);
    }

    //if the method returns 0 the attribute is string
    //if the method returns 1 the attribute is integer
    //if the method returns 2 the attribute is double
    public static int typeOfAttribute(String attribute) {
        int countPoints = 0;
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i) == '.') {
                countPoints++;
            } else if (attribute.charAt(i) > '9' || attribute.charAt(i) < '0' || countPoints > 1) {
                return 0;
            }
        }
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i) == '.') {
                return 2;
            }
        }
        return 1;
    }

    public static int typeOfView(){
        System.out.println(ASK_FOR_TYPE_OD_VISUALISATION);
        System.out.println(SHOW_ALL_ELEMENTS);
        System.out.println(SEARCH_BY_ATTRIBUTE);
        System.out.print("Enter the option for visualisation: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
