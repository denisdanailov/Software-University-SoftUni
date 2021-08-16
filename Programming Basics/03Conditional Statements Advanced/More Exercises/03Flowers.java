package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int flower1 = Integer.parseInt(scan.nextLine());
        int roses = Integer.parseInt(scan.nextLine());
        int tulips = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        char holiday = scan.next().charAt(0);

        double priceFlower1 = 0;
        double priceRoses = 0;
        double priceTulips = 0;
        double bouquet = 0;

        switch (season) {
            case "Spring":
                priceFlower1 = 2.00;
                priceRoses = 4.10;
                priceTulips = 2.50;
                bouquet = (priceFlower1 * flower1) + (priceRoses * roses) + (priceTulips * tulips);
                switch (holiday) {
                    case 'Y':
                    bouquet += bouquet * 0.15;
                    break;
                }
                if (tulips > 7) {
                    bouquet -= bouquet * 0.05;
                }
                break;
            case "Summer":
                priceFlower1 = 2.00;
                priceRoses = 4.10;
                priceTulips = 2.50;
                bouquet = (priceFlower1 * flower1) + (priceRoses * roses) + (priceTulips * tulips);
                switch (holiday) {
                    case 'Y':
                        bouquet += bouquet * 0.15;
                        break;
                }
                break;
            case "Autumn":
                priceFlower1 = 3.75;
                priceRoses = 4.50;
                priceTulips = 4.15;
                bouquet = (priceFlower1 * flower1) + (priceRoses * roses) + (priceTulips * tulips);
                switch (holiday) {
                    case 'Y':
                        bouquet += bouquet * 0.15;
                        break;
                }
                break;
            case "Winter":
                priceFlower1 = 3.75;
                priceRoses = 4.50;
                priceTulips = 4.15;
                bouquet = (priceFlower1 * flower1) + (priceRoses * roses) + (priceTulips * tulips);
                switch (holiday) {
                    case 'Y':
                        bouquet += bouquet * 0.15;
                        break;
                }
                if (roses >= 10) {
                    bouquet -= bouquet * 0.10;
                }
                break;
        }
        if ((flower1 + roses + tulips) > 20) {
            bouquet -= bouquet * 0.20;
        }
        bouquet += 2;

        System.out.printf("%.2f", bouquet);
    }
}
