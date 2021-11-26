package polymorphism.exercises.vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public String drive(double distance) {
        double fuelConsumption = super.getFuelConsumption();
        double fuelQuantity = super.getFuelQuantity();

        if(fuelQuantity / fuelConsumption < distance) {
            return "Truck needs refueling";
        }

        double fuelNeeded = fuelConsumption * distance;

        super.setFuelQuantity(fuelQuantity - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("Truck travelled %s km", formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        double fuelQuantity = super.getFuelQuantity();
        super.setFuelQuantity(fuelQuantity + (liters * 0.95));
    }
}
