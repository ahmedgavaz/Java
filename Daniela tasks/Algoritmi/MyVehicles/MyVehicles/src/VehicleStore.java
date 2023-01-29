import java.util.ArrayList;

public class VehicleStore {
    private static int counter = 1;

    private int vehicleStoreID;
    private static final int MAX_SIZE = 1000;
    private static int currentSize = 0;
    private ArrayList<Vehicle> list;

    public VehicleStore() {
        list = new ArrayList<>();
        vehicleStoreID = counter;
        counter++;
    }

    public void clean() {
        list.clear();
        currentSize = 0;
    }

    public Vehicle getVehicle(int vehicleID) {
        for (Vehicle vehicle : list) {
            if (vehicle.getVehicleID() == vehicleID) {
                return vehicle;
            }
        }
        System.out.println("not found");
        return null;
    }

    public void insert(Vehicle vehicle) {
        if (currentSize < MAX_SIZE) {
            vehicle.setVehicleStoreID(vehicleStoreID);
            list.add(vehicle);
            currentSize++;
        } else {
            throw new RuntimeException("The store is full and there is no space for more vehicles!");
        }
    }

    public void update(Vehicle vehicle) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVehicleID() == vehicle.getVehicleID()) {
                list.remove(list.get(i));
                vehicle.setVehicleStoreID(vehicleStoreID);
                list.add(i, vehicle);
            }
        }
    }

    public void delete(int vehicleID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVehicleID() == vehicleID) {
                list.remove(list.get(i));
                currentSize--;
            }
        }
    }

    public Vehicle search(String attribute) {
        boolean isString = false;
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i) > '9' ||  attribute.charAt(i) < '0') {
                isString = true;
                break;
            }
        }
        boolean isDouble = false;
        for (int i = 0; i < attribute.length(); i++) {
            if (attribute.charAt(i) == '.') {
                isDouble = true;
                break;
            }
        }
        if (isString) {
            for (Vehicle vehicle : list) {
                if (vehicle.getVehicleDesc().equals(attribute) || vehicle.getVehicleType().equals(attribute) || (vehicle.getLicensePlate() != null && vehicle.getLicensePlate().equals(attribute))) {
                    return vehicle;
                }
            }
        } else if (isDouble) {
            for (Vehicle vehicle : list) {
                if (vehicle.getVehicleValue() == Double.parseDouble(attribute)) {
                    return vehicle;
                }
            }
        } else {
            for (Vehicle vehicle : list) {
                if (vehicle.getVehicleID() == Integer.parseInt(attribute) || vehicle.getYearOfProduction() == Integer.parseInt(attribute) || vehicle.getVehicleValue() == Double.parseDouble(attribute)) {
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Vehicle vehicle : list) {
             str.append(vehicle.toString());
        }
        String string = str.toString();
        return string;
    }
}
