/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author danie
 */
class VehicleManager {
    //private VehicleStore store1;

    public static int countStores = 0;
    //private final ArrayList<Vehicle> listOfVehicles= new ArrayList();
    private final ArrayList<VehicleStore> vehicleStores = new ArrayList();

    public VehicleManager() {
    }

    public void showMainMenu() {
        System.out.println("\t\tTest vehicles created:\n");
        /*store1.create5TestVehicles();
        store1.printAllVehicles();*/
        int selection;

        while (true) {
            System.out.println("\n\t\tMain menu");
            System.out.println("Clean the store \t\t1");  //for a tab and space between the codes 
            System.out.println("Get a vehicle by ID\t\t2");
            System.out.println("Insert a vehicle\t\t3");
            System.out.println("Update a vehicle\t\t4");
            System.out.println("Delete a vehicle\t\t5");
            System.out.println("Search a vehicle\t\t6");
            System.out.println("Show all vehicles\t\t7");
            System.out.println("Add shop\t\t\t\t8");
            System.out.println("Generate vehicles\t\t9");
            System.out.println("Exit application\t\t0\n");

            selection = getSelection(9);

            switch (selection) {
                case 0:
                    closeTheApp();
                    break;
                case 1:
                    cleanAStore();
                    break;
                case 2:
                    getAVehicle();
                    break;
                case 3:
                    insertNewVehicle();
                    break;
                case 4:
                    updateAVehicle();
                    break;
                case 5:
                    deleteAVehicle();
                    break;
                case 6:
                    searchAVehicle();
                    break;
                case 7:
                    showAllVehicles();
                    break;
                case 8:
                    addShop();
                    break;
                case 9:
                    generation();
                    break;
            }
        }
    }

    private int idOfShop(int id) {
        for (int i = 0; i < vehicleStores.size(); i++) {
            if (vehicleStores.get(i).getVehicleStoreID() == id) {
                return i;
            }
        }
        return -1;
    }

    private void generation() {
        System.out.print("Enter ID of the store you want to generate: ");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        int i = idOfShop(id);
        if (i >= 0) {
            vehicleStores.get(i).create5TestVehicles();
            System.out.printf("Generated 5 vehicles in store with ID %d.\n", id);
            pressEnter2Continue();
            return;
        }
        System.out.println("This store does not exist.");
        pressEnter2Continue();
    }

    private void addShop() {
        vehicleStores.add(new VehicleStore());
    }

    private int getSelection(int maxSelection) {
        int usersSelection;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Please enter your selection (0=exit): ");
            String input = keyboard.nextLine().trim();
            try {
                usersSelection = Integer.parseInt(input);
            } catch (Exception e) {
                usersSelection = -1;
            }
        } while ((usersSelection < 0) || (usersSelection > maxSelection));  //loop as long as input is bad

        return usersSelection;
    }

    private void closeTheApp() {
        System.out.println("\r\n\r\nThank you and bye bye!\r\n\r\n");
        System.exit(0);
    }

    public void cleanAStore() {
        System.out.print("Enter ID of the store you want to clean: ");
        int storeID = validateInput();
        int i = idOfShop(storeID);
        if (i >= 0) {
            vehicleStores.get(i).cleanStore();
            System.out.printf("Store with ID=%d is cleaned.\n", storeID);
            pressEnter2Continue();
            return;
        }
        System.out.println("This store does not exist.");
        pressEnter2Continue();
    }

    private void getAVehicle() {
        System.out.print("Enter vehicle ID: ");
        int vehicleID = validateInput();
        System.out.print("Enter store ID: ");
        int storeID = validateInput();
        int i = idOfShop(storeID);
        if (i >= 0) {
            Vehicle vehicle = vehicleStores.get(i).getVehicle(vehicleID);
            if (vehicle != null) {
                System.out.format("You get this vehicle: " + vehicleStores.get(i).getVehicle(vehicleID).toString() + "\n");
                pressEnter2Continue();
            }
        }
    }

    private String licensePlateAsk() {
        System.out.print("Do you want to enter licence plate?\nY/N: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        String licensePlate = "";
        if (answer.toUpperCase().trim().equals("Y")) {
            System.out.print("Enter license plate: ");
            licensePlate = scanner.nextLine();
            return licensePlate;
        } else {
            return null;
        }
    }

    private void insertNewVehicle() {
        boolean havePlate = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter vehicle description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Enter year of production: ");
        int yearOfProduction = validateInput();
        System.out.print("Enter vehicle value: ");
        double value = validateValue();
        String licensePlate = licensePlateAsk();
        System.out.print("Enter id of the store for inserting: ");
        int storeID = Integer.parseInt(scanner.nextLine());
        if (idOfShop(storeID) >= 0) {
            if (licensePlate != null) {
                Vehicle vehicle = new Vehicle(description, type, licensePlate, yearOfProduction, value);
                vehicleStores.get(storeID - 1).insertVehicle(vehicle);
                System.out.format("You created vehicle: " + vehicle.toString() + "\n");
            } else {
                Vehicle vehicle = new Vehicle(description, type, yearOfProduction, value);
                vehicleStores.get(storeID - 1).insertVehicle(vehicle);
                System.out.format("You created vehicle: " + vehicle.toString() + "\n");
            }
            pressEnter2Continue();
        } else {
            System.out.println("Store not found.");
            pressEnter2Continue();
        }
    }

    private void updateAVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter vehicle id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter vehicle description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Enter year of production: ");
        int yearOfProduction = validateInput();
        System.out.print("Enter vehicle value: ");
        double value = validateValue();
        String licensePlate = licensePlateAsk();
        Vehicle vehicle;
        System.out.print("Enter id of the store for inserting: ");
        int storeID = Integer.parseInt(scanner.nextLine());
        if (idOfShop(storeID) >= 0) {
            if (licensePlate != null) {
                vehicle = new Vehicle(description, type, licensePlate, yearOfProduction, value);
            } else {
                vehicle = new Vehicle(description, type, yearOfProduction, value);
                vehicle.setVehicleID(id);
            }
            vehicleStores.get(storeID - 1).updateVehicle(vehicle);
            pressEnter2Continue();
            return;
        }
        System.out.format("No store found.\n");
        pressEnter2Continue();
    }

    private void deleteAVehicle() {
        System.out.print("\nEnter vehicleID that you want to delete: ");
        int vehicleID = validateInput();
        System.out.print("Enter store ID: ");
        int storeID = validateInput();
        if (idOfShop(storeID) >= 0) {
            boolean bol = vehicleStores.get(storeID - 1).deleteVehicle(vehicleID);
            if (bol){
                System.out.println("\nThe vehicle was deleted successfully!  ");
            }else{
                System.out.println("No vehicle found.");
            }
            pressEnter2Continue();
            return;
        }
        System.out.println("No store found \n");
        pressEnter2Continue();
    }

    private void searchAVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an attribute for the vehicle you are searching: ");
        String attribute = scanner.nextLine();
        boolean isFound = false;
        for (int i = 0; i < vehicleStores.size(); i++) {
            ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
            vehicleArrayList = vehicleStores.get(i).searchVehicle(attribute);
            if (vehicleArrayList.size() > 0) {
                isFound = true;
                for (Vehicle vehicle : vehicleArrayList) {
                    System.out.println("You get this " + vehicle.toString() + "\n");
                }
            }
        }
        if (!isFound) {
            System.out.println("No vehicle found.");
        }
        pressEnter2Continue();
    }

    private void showAllVehicles() {
        System.out.print("Enter store ID: ");
        int storeID = validateInput();
        if (idOfShop(storeID) >= 0) {
            vehicleStores.get(storeID - 1).printAllVehicles();
            pressEnter2Continue();
            return;
        }
        System.out.print("This vehicle store does not exist.\n");
        pressEnter2Continue();
    }

    private static int validateInput() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.print("Invalid input! Try again. ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    private double validateValue() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.print("Invalid input! Try again. ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    private void pressEnter2Continue() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press ENTER to continue...");
        keyboard.nextLine();
    }
}
