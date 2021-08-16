package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numJuniors = Integer.parseInt(scan.nextLine());
        int numSeniors = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();

        double priceJuniors = 0;
        double priceSeniors = 0;

        switch (type) {
            case "trail":
                priceJuniors = 5.50;
                priceSeniors = 7.0;
                break;
            case "cross-country":
                priceJuniors = 8.0;
                priceSeniors = 9.50;
                if ((numJuniors + numSeniors) >= 50) {
                    priceJuniors -= priceJuniors * 0.25;
                    priceSeniors -= priceSeniors * 0.25;
                }
                break;
            case "downhill":
                priceJuniors = 12.25;
                priceSeniors = 13.75;
                break;
            case "road":
                priceJuniors = 20.0;
                priceSeniors = 21.50;
                break;
        }
        double amount = (priceJuniors * numJuniors) + (priceSeniors * numSeniors);
        double expenses = amount * 0.05;
        amount -= expenses;

        System.out.printf("%.2f", amount);
    }
}
