package Simple_Version.Without_Submenues;

import java.util.Scanner;

public class MainMenuWithoutSubmenus {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        showMainMenu();
        showChosenMenu();
    }

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

    private static void showVoucherMenuSimple() {
        System.out.println("Voucher menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showMaintenanceAndRepairMenuSimple() {
        System.out.println("Maintenance and repair menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showExtraMenuSimple() {
        System.out.println("Extras menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showEmployeeMenuSimple() {
        System.out.println("Employee menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showBookingMenuSimple() {
        System.out.println("Booking menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showTouristMenuSimple() {
        System.out.println("Tourist menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");
    }

    private static void showBoatMenuSimple() {
        System.out.println("Boat menu: program section currently not implemented");
        System.out.println("Press ENTER to return to the main menu");        
    }
    public static void showMainMenu(){
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

