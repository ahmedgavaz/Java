package Vehicles_Extension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));
        String[] busInput = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]) {
                case "Drive":
                    if (vehicleMap.get(input[1]) instanceof Bus) {
                        System.out.println(((Bus) vehicleMap.get(input[1])).drive(Double.parseDouble(input[2]), false));
                    } else {
                        System.out.println(vehicleMap.get(input[1]).drive(Double.parseDouble(input[2])));
                    }
                    break;
                case "Refuel":
                    vehicleMap.get(input[1]).refuel(Double.parseDouble(input[2]));
                    break;
                case "DriveEmpty":
                    if (vehicleMap.get(input[1]) instanceof Bus) {
                        System.out.println(((Bus) vehicleMap.get(input[1])).drive(Double.parseDouble(input[2]), true));
                    }
                    break;
            }
        }
        vehicleMap.values().forEach(e -> System.out.println(e));
    }
}
