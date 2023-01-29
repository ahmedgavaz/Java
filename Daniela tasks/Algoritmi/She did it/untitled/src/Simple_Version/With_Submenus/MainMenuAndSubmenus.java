package Simple_Version.With_Submenus;


import java.util.Scanner;

import static Simple_Version.Without_Submenues.MainMenuWithoutSubmenus.showMainMenu;

/**
 *This class shows not only the main menu but then also the submenus when user inputs his desired choice
 * @author Daniela Dolenska
 */
public class MainMenuAndSubmenus {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * starts the main method which executes the showMainMenu() method and the showChosenMenu()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMainMenu();
        showChosenMenu();
    }

    /**
     * method that asks the user to choose one of the submenus as an option
     * it loops as long as the user inserts wrong input
     * the input number corresponds to a certain menu
     */
    private static void showChosenMenu() {
        String option = scanner.nextLine();
        while (true) {
            System.out.println();
            switch (option) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    showBoatMenu();
                    int resultBoat = showChosenSubMenu("boat");
                    if (resultBoat == 0){
                        break;
                    }
                    continue;
                case "2":
                    showTouristMenu();
                    int resultTourist = showChosenSubMenu("tourist");
                    if (resultTourist == 0){
                        break;
                    }
                    continue;
                case "3":
                    showBookingMenu();
                    int resultBooking = showChosenSubMenu("booking");
                    if (resultBooking == 0){
                        break;
                    }
                    continue;
                case "4":
                    showEmployeeMenu();
                    int resultEmployee = showChosenSubMenu("employee");
                    if (resultEmployee == 0){
                        break;
                    }
                    continue;
                case "5":
                    showExtraMenu();
                    int resultExtra = showChosenSubMenu("extra");
                    if (resultExtra == 0){
                        break;
                    }
                    continue;
                case "6":
                    showMaintenanceAndRepairMenu();
                    int resultRepair = showChosenSubMenu("maintenance and repair");
                    if (resultRepair == 0){
                        break;
                    }
                    continue;
                case "7":
                    showVoucherMenu();
                    int resultVoucher =showChosenSubMenu("voucher");
                    if (resultVoucher == 0){
                        break;
                    }
                    continue;
                default:
                    showMainMenu();
                    option = scanner.nextLine();
                    continue;
            }
            showMainMenu();
            option = scanner.nextLine();
        }
    }

    /**
     * depending on the input from the showChosenMenu() method, this method show a string output,that the certain option from the menu is not implemented
     * @param element taken from the showChosenMenu() method
     * @return returns 0 if the user wants to return to the submenu, and 1 if he has chosen a certain submenu
     */
    private static int showChosenSubMenu(String element) {
        String option = scanner.nextLine();
        System.out.println();
            switch (option) {
                case "0":
                    showMainMenu();
                    return 0;
                case "1":
                    System.out.printf("Adding %s:currently not yet implemented! Press <ENTER> ", element);
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.printf("Updating %s:currently not yet implemented! Press <ENTER> ", element);
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.printf("Deleting %s:currently not yet implemented! Press <ENTER> ", element);
                    scanner.nextLine();
                    break;
                case "4":
                    if (element.equals("maintenance and repair")){
                        System.out.print("Showing maintenances and repairs:currently not yet implemented! Press <ENTER>");
                        scanner.nextLine();
                    }else{
                        System.out.printf("Showing %ss:currently not yet implemented! Press <ENTER>", element);
                        scanner.nextLine();
                    }
                    break;
                default:
                    break;
            }
        System.out.println();
            return 1;
    }

    /**
     * shows simply the voucher menu as a text on the console
     */
    private static void showVoucherMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING VOUCHERS MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new voucher            1");
        System.out.println("Update an existing voucher     2");
        System.out.println("Delete an existing voucher     3");
        System.out.println("Show a list of all vouchers    4");
        System.out.println();
        System.out.println("Return to main menu            0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the maintenance menu as a text on the console
     */
    private static void showMaintenanceAndRepairMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING MAINTENANCE AND REPAIR MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new maintenance and repair             1");
        System.out.println("Update an existing maintenance and repair      2");
        System.out.println("Delete an existing maintenance and repair      3");
        System.out.println("Show a list of all maintenances and repairs    4");
        System.out.println();
        System.out.println("Return to main menu                            0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the extras menu as a text on the console
     */
    private static void showExtraMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING EXTRAS MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new extra            1");
        System.out.println("Update an existing extra     2");
        System.out.println("Delete an existing extra     3");
        System.out.println("Show a list of all extras    4");
        System.out.println();
        System.out.println("Return to main menu          0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the employee menu as a text on the console
     */
    private static void showEmployeeMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING EMPLOYEE MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new employee            1");
        System.out.println("Update an existing employee     2");
        System.out.println("Delete an existing employee     3");
        System.out.println("Show a list of all employees    4");
        System.out.println();
        System.out.println("Return to main menu             0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the booking menu as a text on the console
     */
    private static void showBookingMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING BOOKINGS MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new booking            1");
        System.out.println("Update an existing booking     2");
        System.out.println("Delete an existing booking     3");
        System.out.println("Show a list of all bookings    4");
        System.out.println();
        System.out.println("Return to main menu            0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the tourist menu as a text on the console
     */
    private static void showTouristMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING TOURISTS MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new tourist            1");
        System.out.println("Update an existing tourist     2");
        System.out.println("Delete an existing tourist     3");
        System.out.println("Show a list of all tourists    4");
        System.out.println();
        System.out.println("Return to main menu            0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }

    /**
     * shows simply the boat menu as a text on the console
     */
    private static void showBoatMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("               MANAGING BOATS MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Setup a new boat            1");
        System.out.println("Update an existing boat     2");
        System.out.println("Delete an existing boat     3");
        System.out.println("Show a list of all boats    4");
        System.out.println();
        System.out.println("Return to main menu         0");
        System.out.println();
        System.out.print("Enter your choice here: ");
    }
    
    /**
     * shows simply the main menu as a text on the console
     */
    public static void showMainMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("              MAIN MENU");
        System.out.println("Please select:");
        System.out.println();
        System.out.println("Managing boats                  1");
        System.out.println("Managing tourists               2");
        System.out.println("Managing bookings               3");
        System.out.println("Managing employees              4");
        System.out.println("Managing extras                 5");
        System.out.println("Managing maintenance&repair     6");
        System.out.println("Managing vouchers               7");
        System.out.println();
        System.out.println("Program exit                    0");
        System.out.println();
        System.out.print("Enter your choice: ");
    }
}
