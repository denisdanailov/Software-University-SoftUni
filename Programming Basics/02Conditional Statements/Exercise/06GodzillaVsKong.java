package ConditionalStatements.Exercises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int actors = Integer.parseInt(scan.nextLine());
        double priceClothes = Double.parseDouble(scan.nextLine());

        double decor = budget * 0.10;

        if (actors > 150) {
            priceClothes = priceClothes - (priceClothes * 0.10);
        }

        double priceMovie = decor + (actors * priceClothes);

        if (priceMovie > budget) {
            double moneyNeeded = priceMovie - budget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", moneyNeeded);
        } else {
            double leftMoney = budget - priceMovie;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", leftMoney);
        }
    }
}
