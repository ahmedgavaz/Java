package Vehicles;

public class Truck extends Vehicle{
    private final static double AC_CONSUMPTION=1.6;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+AC_CONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        fuel*=0.95;
        super.refuel(fuel);
    }
}
