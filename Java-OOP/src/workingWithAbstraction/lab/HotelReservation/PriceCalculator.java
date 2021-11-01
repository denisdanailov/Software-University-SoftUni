package workingWithAbstraction.lab.HotelReservation;

public class PriceCalculator {
    public static double calculate(double price, int days, String season, String discountType) {
        int multiplicator = Season.valueOf(season.toUpperCase()).getMultiplicator();
        double discountPrice = Discount.getDiscountType(discountType).getDiscount();

        double totalPrice = (price * multiplicator) * days;
        discountPrice *= totalPrice;
        return totalPrice - discountPrice;
    }
}
