package Vehicles_Extension;

public class Truck extends Vehicle{
    private final static double AC_CONSUMPTION=1.6;
    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption+AC_CONSUMPTION,tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        fuel*=0.95;
        super.refuel(fuel);
    }
}
