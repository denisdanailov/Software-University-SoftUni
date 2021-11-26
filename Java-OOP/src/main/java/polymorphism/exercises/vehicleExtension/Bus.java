package polymorphism.exercises.vehicleExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.4, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        if (super.getFuelQuantity() / super.getFuelConsumption() < distance) {
            return "Bus needs refueling";
        }
        double fuelNeeded = distance * super.getFuelConsumption();

        setFuelQuantity(super.getFuelQuantity() - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("Bus travelled %s km", formatter.format(distance));
    }

}
