package polymorphism.exercises.vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car (double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public String drive(double distance) {
        if (super.getFuelQuantity() / super.getFuelConsumption() < distance) {
            return "Car needs refueling";
        }
        double fuelNeeded = distance * super.getFuelConsumption();
        setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("Car travelled %s km", formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        double currQuantity = super.getFuelQuantity();
        super.setFuelQuantity(currQuantity + liters);
    }
}
