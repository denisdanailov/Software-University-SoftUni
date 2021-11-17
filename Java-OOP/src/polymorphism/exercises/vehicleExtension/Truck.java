package polymorphism.exercises.vehicleExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6,tankCapacity);
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
    public  void refuel(double liters) {
        if (liters > 0) {
            double currQuantity = this.getFuelQuantity();
            this.setFuelQuantity(currQuantity + (liters * 0.95));
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
