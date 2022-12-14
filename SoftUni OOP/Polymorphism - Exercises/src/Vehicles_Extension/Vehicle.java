package Vehicles_Extension;

import java.text.DecimalFormat;

public class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        if (fuelQuantity >= distance * fuelConsumption) {
            this.fuelQuantity -= distance * fuelConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }

    public void refuel(double fuel) {
        if (fuel>0 && fuel<=tankCapacity-fuelQuantity){
            this.fuelQuantity += fuel;
        }else if (fuel<=0){
            System.out.println("Fuel must be a positive number");
        }else if (fuel>tankCapacity-fuelQuantity){
            System.out.println("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
