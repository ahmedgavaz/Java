import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle_Catalogue {
    public static class Vehicle {
        String typeVehicle;
        String model;
        String color;
        Integer horsePower;

        public Vehicle(String typeVehicle, String model, String color, Integer horsePower) {
            this.typeVehicle = typeVehicle;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getModel() {
            return model;
        }

        public Integer getHorsePower() {
            return horsePower;
        }

        public String getColor() {
            return color;
        }

        public String getTypeVehicle() {
            return typeVehicle;
        }

        public void setTypeVehicle(String typeVehicle) {
            this.typeVehicle = typeVehicle;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String command = scanner.nextLine();
        int countCars = 0;
        int countTrucks = 0;
        int hpCars = 0;
        int hpTrucks = 0;
        while (!command.equals("End")) {
            String[] catalog = command.split(" ");
            Vehicle singleVehicle = new Vehicle(catalog[0], catalog[1], catalog[2], Integer.parseInt(catalog[3]));
            vehicles.add(singleVehicle);
            if (catalog[0].equals("truck")) {
                countTrucks++;
                hpTrucks += Integer.parseInt(catalog[3]);
            } else {
                countCars++;
                hpCars += Integer.parseInt(catalog[3]);
            }
            command = scanner.nextLine();
        }
        while (!command.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(command)) {
                    if (vehicle.getTypeVehicle().equals("car")) {
                        vehicle.setTypeVehicle("Car");
                    } else {
                        vehicle.setTypeVehicle("Truck");
                    }
                    System.out.println("Type: " + vehicle.getTypeVehicle());
                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Horsepower: " + vehicle.getHorsePower());
                }
            }
            command = scanner.nextLine();
        }
        if (countCars == 0) {
            System.out.printf("Cars have average horsepower of: 0.00.%n");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", hpCars * 1.0 / countCars);
        }
        if (countTrucks == 0) {
            System.out.printf("Trucks have average horsepower of: 0.00.%n");
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", hpTrucks * 1.0 / countTrucks);
        }
    }
}
