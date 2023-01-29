package Non_Simple_Version;


import Non_Simple_Version.Management.*;

import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.typeOfView;

public class ShopManagement {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(String.valueOf(123.45).equals("123.4"));
        showMainMenu();
        showChosenMenu();
    }

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
                    String chooseBoat = scanner.nextLine();
                    switch (chooseBoat) {
                        case "0":
                            break;
                        case "1":
                            BoatManager.addBoat();
                            break;
                        case "2":
                            BoatManager.updateBoat();
                            break;
                        case "3":
                            BoatManager.deleteBoat();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                                BoatManager.listBoats();
                            } else if (type == 2) {
                                BoatManager.searchBoat();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;

                case "2":
                    showTouristMenu();
                    String chooseTourist = scanner.nextLine();
                    switch (chooseTourist) {
                        case "0":
                            break;
                        case "1":
                            TouristManager.addTourist();
                            break;
                        case "2":
                            TouristManager.updateTourist();
                            break;
                        case "3":
                            TouristManager.deleteTourist();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                                TouristManager.searchTourist();
                            } else if (type == 2) {
                                TouristManager.searchTourist();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case "3":
                    showBookingMenu();
                    String chooseBooking = scanner.nextLine();
                    switch (chooseBooking) {
                        case "0":
                            break;
                        case "1":
                            BookingManager.addBooking();
                            break;
                        case "2":
                            BookingManager.updateBooking();
                            break;
                        case "3":
                            BookingManager.deleteBooking();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                                BookingManager.listBooking();
                            } else if (type == 2) {
                                BookingManager.searchBooking();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case "4":
                    showEmployeeMenu();
                    String chooseEmployee = scanner.nextLine();
                    switch (chooseEmployee) {
                        case "0":
                            break;
                        case "1":
                            EmployeeManager.addEmployee();
                            break;
                        case "2":
                            EmployeeManager.updateEmployee();
                            break;
                        case "3":
                            EmployeeManager.deleteEmployee();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                                EmployeeManager.listEmployee();
                            } else if (type == 2) {
                                EmployeeManager.searchEmployee();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case "5":
                    showExtraMenu();
                    String chooseExtra = scanner.nextLine();
                    switch (chooseExtra) {
                        case "0":
                            break;
                        case "1":
                            ExtrasManager.addExtra();
                            break;
                        case "2":
                            ExtrasManager.updateExtra();
                            break;
                        case "3":
                            ExtrasManager.deleteExtra();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                                ExtrasManager.listExtras();
                            } else if (type == 2) {
                                ExtrasManager.searchExtra();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case "6":
                    showMaintenanceAndRepairMenu();
                    String chooseRepair = scanner.nextLine();
                    switch (chooseRepair) {
                        case "0":
                            break;
                        case "1":
                            MaintenanceAndRepairManager.addMaintenance();
                            break;
                        case "2":
                            MaintenanceAndRepairManager.updateMaintenance();
                            break;
                        case "3":
                            MaintenanceAndRepairManager.deleteMaintenance();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                              MaintenanceAndRepairManager.listMaintenance();
                            } else if (type == 2) {
                                MaintenanceAndRepairManager.searchMaintenance();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                case "7":
                    showVoucherMenu();
                    String chooseVoucher = scanner.nextLine();
                    switch (chooseVoucher) {
                        case "0":
                            break;
                        case "1":
                            VoucherManager.addVoucher();
                            break;
                        case "2":
                            VoucherManager.updateVoucher();
                            break;
                        case "3":
                            VoucherManager.deleteVoucher();
                            break;
                        case "4":
                            int type = typeOfView();
                            if (type == 1) {
                               VoucherManager.listVouchers();
                            } else if (type == 2) {
                                VoucherManager.searchVoucher();
                            } else {
                                continue;
                            }
                            break;
                        default:
                            continue;
                    }
                    break;
                default:
                    showMainMenu();
                    option = scanner.nextLine();
                    continue;
            }
            showMainMenu();
            option = scanner.nextLine();
        }
    }

    private static void showVoucherMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showMaintenanceAndRepairMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showExtraMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showEmployeeMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showBookingMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showTouristMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    private static void showBoatMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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

    public static void showMainMenu() {
        System.out.println("BOAT PARADISE Xenia & Leon");
        System.out.println("Basic Data Management 1.0 Copyright © 2022 John Doe, MNR 300013");
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
