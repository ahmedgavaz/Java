public class VehicleManager {
    private VehicleStore store;

    public VehicleManager() {
        this.store=new VehicleStore();
    }

    public void generator(){
        Vehicle vehicle1 = new Vehicle("Green","Bike",2015,249.99);
        Vehicle vehicle2 = new Vehicle("Black","e-Bike",2022,649.99);
        Vehicle vehicle3 = new Vehicle("White","Boat",2018,6599.99);
        Vehicle vehicle4 = new Vehicle("Blue","Car","E 0177 BG",2019,22200);
        Vehicle vehicle5 = new Vehicle("Red","Motorcycle","SO 1914 TR",2014,3500);
        store.insert(vehicle1);
        store.insert(vehicle2);
        store.insert(vehicle3);
        store.insert(vehicle4);
        store.insert(vehicle5);
    }

    public void insert(Vehicle vehicle){
        store.insert(vehicle);
    }

    public void clean(){
        store.clean();
    }

    public Vehicle getVehicle(int vehicleID){
        return store.getVehicle(vehicleID);
    }

    public void update(Vehicle vehicle){
        store.update(vehicle);
    }

    public void delete(int vehicleID){
        store.delete(vehicleID);
    }

    public VehicleStore getStore() {
        return store;
    }

    public Vehicle search(String attribute){
        return store.search(attribute);
    }
}
