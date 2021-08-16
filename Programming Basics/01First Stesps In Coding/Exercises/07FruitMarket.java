package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double priceStrawberries = Double.parseDouble(scan.nextLine());
        Double bananas = Double.parseDouble(scan.nextLine());
        Double Oranges = Double.parseDouble(scan.nextLine());
        Double Raspberries = Double.parseDouble(scan.nextLine());
        Double Strawberries = Double.parseDouble(scan.nextLine());

        Double priceRaspberries = priceStrawberries - (priceStrawberries * 0.5);
        Double priceOranges = priceRaspberries - (priceRaspberries * 0.4);
        Double priceBananas = priceRaspberries - (priceRaspberries * 0.8);

        Double sumPriceStrawberries = priceStrawberries * Strawberries;
        Double sumPriceRaspberries = priceRaspberries * Raspberries;
        Double sumPriceOranges = priceOranges * Oranges;
        Double sumPriceBananas = priceBananas * bananas;

        Double totalPrice = sumPriceStrawberries + sumPriceRaspberries + sumPriceOranges + sumPriceBananas;

        System.out.printf("%.2f",totalPrice);
    }
}
