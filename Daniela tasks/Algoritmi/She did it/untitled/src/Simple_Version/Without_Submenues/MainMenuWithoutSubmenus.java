package Simple_Version.Without_Submenues;

import java.util.Scanner;

/**
 *This class shows only the main menu, without any other submenus afterwards
 * @author Daniela Dolenska
 */
public class MainMenuWithoutSubmenus {
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * starts the main method which calls the showMainMenu() method and the showChosenMenu()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMainMenu();
        showChosenMenu();
    }

    /**
     * asks the user to give as an input the menu to show
     */
    private static void showChosenMenu(){
        String  option = scanner.nextLine();
        while (true){
            System.out.println();
            switch (option){
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    showBoatMenuSimple();
                    break;
                case "2":
                    showTouristMenuSimple();
                    break;
                case "3":
                    showBookingMenuSimple();
                    break;
                case "4":
                    showEmployeeMenuSimple();
                    break;
                case "5":
                    showExtraMenuSimple();
                    break;
                case "6":
                    showMaintenanceAndRepairMenuSimple();
                    break;
                case "7":
                    showVoucherMenuSimple();
                    break;
                default:
                    showMainMenu();
                    option = scanner.nextLine();
                    continue;
            }
            scanner.nextLine();
            showMainMenu();
            option = scanner.nextLine();
        }
    }

    /**
     * output on the console that the voucher menu is not implemented yer
     */
    private static void showVoucherMenuSimple() {
        System.out.println("Voucher menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu" );
    }

    /**
     * output on the console that the maintenance&repair menu is not implemented yer
     */
    private static void showMaintenanceAndRepairMenuSimple() {
        System.out.println("Maintenance and repair menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");
    }

    /**
     * output on the console that the extras menu is not implemented yer
     */
    private static void showExtraMenuSimple() {
        System.out.println("Extras menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");
    }

    /**
     * output on the console that the employee menu is not implemented yer
     */
    private static void showEmployeeMenuSimple() {
        System.out.println("Employee menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");
    }

    /**
     * output on the console that the booking menu is not implemented yer
     */
    private static void showBookingMenuSimple() {
        System.out.println("Booking menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");
    }

    /**
     * output on the console that the tourist menu is not implemented yer
     */
    private static void showTouristMenuSimple() {
        System.out.println("Tourist menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");
    }

    /**
     * output on the console that the boat menu is not implemented yer
     */
    private static void showBoatMenuSimple() {
        System.out.println("Boat menu: program section currently not implemented");
        System.out.print("Press ENTER to return to the main menu ");        
    }
    
    /**
     * shows simply the main menu as a text on the console
     */
    public static void showMainMenu(){
        System.out.println("\nBOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 Daniela Dolenska, MNR 325801");
        System.out.println();
        System.out.println("              MAIN MENU");
        System.out.println("Please select:" );
        System.out.println();
        System.out.println("Managing boats                  1");
        System.out.println("Managing tourists               2" );
        System.out.println("Managing bookings               3" );
        System.out.println("Managing employees              4" );
        System.out.println("Managing extras                 5");
        System.out.println("Managing maintenance&repair     6" );
        System.out.println("Managing vouchers               7" );
        System.out.println();
        System.out.println( "Program exit                    0" );
        System.out.println();
        System.out.print("Enter your choice: ");
    }
}

