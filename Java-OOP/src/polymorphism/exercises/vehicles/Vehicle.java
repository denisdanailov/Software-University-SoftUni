package polymorphism.exercises.vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle (double fuelQuantity, double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        this.fuelQuantity = fuelQuantity;
    }

    public abstract String drive(double distance);
    public abstract void refuel(double liters);

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
