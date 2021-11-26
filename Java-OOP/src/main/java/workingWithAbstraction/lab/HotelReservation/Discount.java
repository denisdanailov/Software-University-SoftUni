package workingWithAbstraction.lab.HotelReservation;

public enum Discount {
    VIP("VIP", 0.2),
    SECOND_VISIT("SecondVisit", 0.1),
    NONE("None", 0);

    private String name;
    private double discount;

    private Discount(String name, double discount) {
        this.discount = discount;
        this.name = name;
    }

    public static Discount getDiscountType(String input){
        return switch (input) {
            case "VIP" -> Discount.VIP;
            case "SecondVisit" -> Discount.SECOND_VISIT;
            case "None" -> Discount.NONE;
            default -> throw new IllegalArgumentException("No Such Discount Type: " + input);
        };
    }

    public String getName() {
        return this.name;
    }

    public double getDiscount() {
        return this.discount;
    }
}
