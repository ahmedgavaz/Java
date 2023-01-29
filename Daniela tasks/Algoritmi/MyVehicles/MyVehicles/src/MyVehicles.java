public class MyVehicles {
    public static void main(String[] args) {
        VehicleManager manager= new VehicleManager();
        manager.generator();
        Vehicle vehicle6 = new Vehicle("Brown","Bus",2012,45999.99);
        System.out.println("Generated store: ");
        System.out.println(manager.getStore());

        manager.insert(vehicle6);
        System.out.println("Store after adding: ");
        System.out.println(manager.getStore());

        manager.delete(2);
        System.out.println("Store after deleting: ");
        System.out.println(manager.getStore());

        Vehicle plane  = new Vehicle("White","Plane",2022,355999.99);
        plane.setVehicleID(1);
        manager.update(plane);
        System.out.println("Store after updating: ");
        System.out.println(manager.getStore());

        Vehicle car = manager.search("Car");
        System.out.println("Searched vehicle by attribute: ");
        System.out.println(car);

        System.out.println("Searched vehicle by id: ");
        Vehicle boat = manager.getVehicle(3);
        System.out.println(boat);

        manager.clean();
        System.out.println("Store after cleaning: ");
        System.out.println(manager.getStore());
        /*Vehicle vehicle1 = new Vehicle("Green","Bike",2015,249.99);
        Vehicle vehicle2 = new Vehicle("Black","e-Bike",2022,649.99);
        Vehicle vehicle3 = new Vehicle("White","Boat",2018,6599.99);
        Vehicle vehicle4 = new Vehicle("Blue","Car","E 0177 BG",2019,22200);
        Vehicle vehicle5 = new Vehicle("Red","Motorcycle","SO 1914 TR",2014,3500);
        Vehicle vehicle6 = new Vehicle("Yellow","Truck",2018,65299.99);
        VehicleStore store = new VehicleStore();
        store.insert(vehicle1);
        store.insert(vehicle2);
        store.insert(vehicle3);
        store.insert(vehicle4);
        System.out.println(store);
        store.delete(1);
        store.insert(vehicle5);
        Vehicle vehicle = store.search("2018");
        System.out.println(vehicle.getVehicleType());
        store.clean();

        VehicleStore store2 = new VehicleStore();
        store2.insert(vehicle1);
        store2.insert(vehicle2);
        store2.insert(vehicle3);
        store2.insert(vehicle4);
        store2.insert(vehicle5);
        store2.update(vehicle6);
        Vehicle result=store.getVehicle(1);
        System.out.println(vehicle.getVehicleType());*/
    }
}
