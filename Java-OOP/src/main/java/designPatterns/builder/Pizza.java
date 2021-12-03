package designPatterns.builder;

public class Pizza {
    private String name;
    private String topping;
    private String crustType;

    private double diameter;
    private double weight;

    private boolean isSpicy;
    private boolean forTakeAway;

    public Pizza() {
    }

    public Pizza withName(String name) {
        this.name = name;
        return this;
    }

    public Pizza withTopping(String topping) {
        this.topping = topping;
        return this;
    }

    public Pizza withCrustType(String crustType) {
        this.crustType = crustType;
        return this;
    }

    public Pizza withDiameter(double diameter) {
        this.diameter = diameter;
        return this;
    }

    public Pizza withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Pizza withSpicy(boolean spicy) {
        this.isSpicy = spicy;
        return this;
    }

    public Pizza withForTakeAway(boolean forTakeAway) {
        this.forTakeAway = forTakeAway;
        return this;
    }
}
