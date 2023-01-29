package Non_Simple_Version;

import Non_Simple_Version.Objects.*;

import java.util.List;
import java.util.Scanner;

public class ValidatorsAndMessages {
    ;
    public static Scanner scanner = new Scanner(System.in);
    public static final String ENTER_BOAT_TYPE = "Enter boat type: ";
    public static final String ENTER_BOAT_PRICE = "Enter boat price: ";
    public static final String ENTER_BOAT_CAPACITY = "Enter boat capacity: ";
    public static final String ADDED_MESSAGE = "You added :\n";
    public static final String NO_BOATS_IN_THE_LIST = "Currently no boats in the list! \n Please add a new boat!";
    public static final String EMPLOYEES_BY_ID = "Employees currently in list by their respective ID are:";
    public static final String BOATS_ID_FOR_UPDATE = "Which boat ID do you want to update?";
    public static final String EMPLOYEE_ID_FOR_UPDATE = "Which employee ID do you want to update?";
    public static final String EXTRA_ID_FOR_UPDATE = "Which extra ID do you want to update?";
    public static final String VOUCHER_ID_FOR_UPDATE = "Which voucher ID do you want to update?";
    public static final String MAINTENANCE_ID_FOR_UPDATE = "Which maintenance or repair ID do you want to update?";
    public static final String NO_BOAT_WITH_THIS_ID = "Boat with this id doesn't exist!";
    public static final String NO_TOURIST_WITH_THIS_ID = "Tourist with this id doesn't exist!";
    public static final String NO_VOUCHER_WITH_THIS_ID = "Voucher with this id doesn't exist!";
    public static final String NO_EMPLOYEE_WITH_THIS_ID = "Employee with this id doesn't exist!";
    public static final String NO_EXTRA_WITH_THIS_ID = "Extra with this id doesn't exist!";
    public static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again.\n";
    public static final String PARSE_ERROR_MESSAGE = "You should input a number bigger than 0!";
    public static final String TO_SUBMENU = "\nPress ENTER to return to sub menu ";
    public static final String BOAT_ID_FOR_DELETING = "Please, select the ID for the boat you wish to delete:";
    public static final String EMPLOYEE_ID_FOR_DELETING = "Please, select the ID for the employee you wish to delete:";
    public static final String EXTRA_ID_FOR_DELETING = "Please, select the ID for the extra you wish to delete:";
    public static final String VOUCHER_ID_FOR_DELETING = "Please, select the ID for the voucher you wish to delete:";
    public static final String MAINTENANCE_ID_FOR_DELETING = "Please, select the ID for the maintenance or repair you wish to delete:";
    public static final String BOATS_IN_THE_LIST = "Boats currently in the list are:";
    public static final String NO_TOURIST_IN_THE_LIST = "Currently no tourists in the list!\nPlease add a new tourist!";
    public static final String NO_BOOKINGS_IN_THE_LIST = "Currently no bookings in the list!\nPlease add a new booking!";
    public static final String CURRENTLY_TOURIST_IN_THE_LIST = "Tourists currently in the list are:";
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
    public static final String DELETION = "You deleted successfully. ";
    public static final String UPDATE = "You updated successfully: \n";
    public static final String MAX_CAPACITY_REACHED = "The reached your capacity of boats.";
    public static final String ASK_FOR_TYPE_OD_VISUALISATION = "Choose tho correct option for visualisation(1 or 2):\n";
    public static final String SHOW_ALL_ELEMENTS = "1.Show all elements.\n";
    public static final String SEARCH_BY_ATTRIBUTE = "2.Search elements by attribute.\n";
    public static final String ENTER_VISUALISATION_OPTION ="Enter the option for visualisation: ";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String INVALID_INPUT = "You should choose 1 or 2!";

    //Този клас получава съобщение за извеждане на конзолата което казва каква променлива да се въведе.
    //След въвеждането на променливата се проверява дали е по-голяма от 0 ако не е се извежда грешка.
    //Метода хваща два вида грешки - когато въведената стойност не е число и когато е число, но е по-малка или равна на 0
    //Методът се извършва до въвеждане на число по-голямо от 0
    public static int validateIntegerInput(String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (NumberFormatException n) {
                System.out.println(PARSE_ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.print(INVALID_INPUT_MESSAGE);
            }
        } while (true);
    }

    //Този клас получава съобщение за извеждане на конзолата което казва каква променлива да се въведе.
    //След въвеждането на променливата се проверява дали дължината на стринга е по-голяма от 0, ако не е се извежда грешка.
    //Ако въведения стринг е празен метода иска да се въвежда стринг до получаване на стринг с по-голяма дължина от 0
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

    //Този клас получава съобщение за извеждане на конзолата което казва каква променлива да се въведе.
    //След въвеждането на променливата се проверява дали е по-голяма от 0 ако не е се извежда грешка.
    //Метода хваща два вида грешки - когато въведената стойност не е число и когато е число, но е по-малка или равна на 0
    //Методът се извършва до въвеждане на число по-голямо от 0
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

    //Методът извежда съобщение да се натисне ентър и се чете въведеното от конзолата
    public static void returnToSubMenu() {
        System.out.print(TO_SUBMENU);
        scanner.nextLine();
    }

    //Този клас получава съобщение за извеждане на конзолата което казва каква променлива да се въведе.
    //След въвеждането на променливата се проверява дали е У или N
    //Методът извежда грешка при въвеждане на нещо друго и извежда съобщението на този грешка
    //Методът се извършва до въвеждане на една от двете стойности
    public static boolean validateDrivingLicenseInput(String str) {
        do {
            try {
                System.out.print(str);
                String value = scanner.nextLine().trim().toUpperCase();
                if (value.equals(YES)) {
                    return true;
                } else if (value.equals(NO)) {
                    return false;
                } else {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                System.out.print(INVALID_INPUT_MESSAGE);
            }
        } while (true);
    }

    //Методът пита за вида на визоализация и извежда възможните избори
    //След това чете избраната опция и я връща
    //При въвеждане на стойност която не е число се извежда съобщение и се връша -1
    public static int typeOfView(){
        System.out.println(ASK_FOR_TYPE_OD_VISUALISATION);
        System.out.println(SHOW_ALL_ELEMENTS);
        System.out.println(SEARCH_BY_ATTRIBUTE);
        System.out.print(ENTER_VISUALISATION_OPTION);
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println(INVALID_INPUT);
            return -1;
        }
    }
}
