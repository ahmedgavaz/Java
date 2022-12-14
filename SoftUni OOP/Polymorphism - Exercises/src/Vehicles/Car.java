package Vehicles;

public class Car extends Vehicle{
    private final static double AC_CONSUMPTION=0.9;
    public Car(double fuelQuantity,double fuelConsumption) {
        super(fuelQuantity,fuelConsumption+AC_CONSUMPTION);
    }
}
