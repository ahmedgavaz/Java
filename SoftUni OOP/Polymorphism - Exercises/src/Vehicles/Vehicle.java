package Vehicles;

import java.text.DecimalFormat;

public class Vehicle{
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance){
        if (fuelQuantity>=distance*fuelConsumption){
            this.fuelQuantity-=distance*fuelConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),decimalFormat.format(distance));
        }else{
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }
    }

    public void refuel(double fuel){
        this.fuelQuantity+=fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
