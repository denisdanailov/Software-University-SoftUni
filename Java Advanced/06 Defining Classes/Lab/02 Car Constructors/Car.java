package DefiningClasses.Lab.CarConstructors;

public class Car {
    // Class Fields
    private String brand;
    private String model;
    private int horsePower;
    // Constructors
    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    public Car(String brand) {
        this(brand, "unknown", -1);
    }
    public Car(int horsePower) {
        this("unknown", "unknown", horsePower);
    }
    public Car(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }
    // Getters
    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }
    public int getHorsePower() {
        return this.horsePower;
    }
    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    // toString() -> Override
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", brand, model, horsePower);
    }
}
