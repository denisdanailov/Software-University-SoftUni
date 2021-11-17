package polymorphism.exercises.vehicleExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car (double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
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

}
