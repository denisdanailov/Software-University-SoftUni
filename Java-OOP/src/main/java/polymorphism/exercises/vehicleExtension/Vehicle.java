package polymorphism.exercises.vehicleExtension;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle (double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelConsumption = fuelConsumption;
        this.fuelQuantity = fuelQuantity;
        this.tankCapacity = tankCapacity;
    }

    public abstract String drive(double distance);

    public  void refuel(double liters) {
        if (liters > 0) {
            double currQuantity = this.getFuelQuantity();
            this.setFuelQuantity(currQuantity + liters);
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= tankCapacity) {
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
