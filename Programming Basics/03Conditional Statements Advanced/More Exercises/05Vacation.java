package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String stay = "";
        String place = "";
        double price = 0;

        if (budget <= 1000) {
            stay = "Camp";
            switch (season) {
                case "Summer":
                    place = "Alaska";
                    price = budget * 0.65;
                    break;
                case "Winter":
                    place = "Morocco";
                    price = budget * 0.45;
                    break;
            }
        } else if (budget > 1000 && budget <= 3000) {
            stay = "Hut";
            switch (season) {
                case "Summer":
                    place = "Alaska";
                    price = budget * 0.80;
                    break;
                case "Winter":
                    place = "Morocco";
                    price = budget * 0.60;
                    break;
            }
        } else {
            stay = "Hotel";
            switch (season) {
                case "Summer":
                    place = "Alaska";
                    price = budget * 0.90;
                    break;
                case "Winter":
                    place = "Morocco";
                    price = budget * 0.90;
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", place, stay, price);
    }
}
