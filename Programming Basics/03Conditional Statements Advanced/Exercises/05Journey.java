package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String place = "";
        String type = "";
        double moneySpent = 0;

        if (budget <= 100) {
            place = "Bulgaria";
            switch (season) {
                case "summer":
                    moneySpent = budget * 0.30;
                    type = "Camp";
                    break;
                case "winter":
                    moneySpent = budget * 0.70;
                    type = "Hotel";
                    break;
            }
        } else if (budget <= 1000) {
            place = "Balkans";
            switch (season) {
                case "summer":
                    moneySpent = budget * 0.40;
                    type = "Camp";
                    break;
                case "winter":
                    moneySpent = budget * 0.80;
                    type = "Hotel";
                    break;
            }
        } else if (budget > 1000) {
            place ="Europe";
            moneySpent = budget * 0.90;
            type = "Hotel";
        }

        System.out.printf("Somewhere in %s", place);
        System.out.println("");
        System.out.printf("%s - %.2f", type, moneySpent);
    }
}