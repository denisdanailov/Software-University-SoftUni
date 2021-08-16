package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String flowers = scan.nextLine();
        int numFlowers = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double priceFlowers = 0;

        switch (flowers) {
            case "Roses":
                priceFlowers = numFlowers * 5;
                if (numFlowers > 80) {
                    priceFlowers *= 0.90;
                }
                break;
            case "Dahlias":
                priceFlowers = numFlowers * 3.80;
                if (numFlowers > 90) {
                    priceFlowers *= 0.85;
                }
                break;
            case "Tulips":
                priceFlowers = numFlowers * 2.80;
                if (numFlowers > 80) {
                    priceFlowers *= 0.85;
                }
                break;
            case "Narcissus":
                priceFlowers = numFlowers * 3;
                if (numFlowers < 120) {
                    priceFlowers += priceFlowers * 0.15;
                }
                break;
            case "Gladiolus":
                priceFlowers = numFlowers * 2.50;
                if (numFlowers < 80) {
                    priceFlowers += priceFlowers * 0.20;
                }
                break;
        }

        if (budget >= priceFlowers) {
            double moneyLeft = budget - priceFlowers;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numFlowers, flowers, moneyLeft);
        } else {
            double moneyNeeded = priceFlowers - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
        }
    }
}
