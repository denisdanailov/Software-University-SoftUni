package interfacesAndAbstraction.lab.carShopExtendet;

public class CarImpl implements Car {

    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %S produced in %s and have %d tires",
                this.model,
                this.countryProduced,
                Car.TIRES);
    }
}
