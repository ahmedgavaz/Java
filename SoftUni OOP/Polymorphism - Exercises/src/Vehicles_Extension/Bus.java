package Vehicles_Extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String drive(double distance, boolean isEmpty) {
        if (!isEmpty) {
            this.fuelConsumption+=1.4;
        }
        if (fuelQuantity >= distance * fuelConsumption) {
            this.fuelQuantity -= distance * fuelConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }
}
