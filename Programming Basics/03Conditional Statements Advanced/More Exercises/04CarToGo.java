package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String comfort = "";
        String type  = "";
        double priceCar = 0;

        if (budget <= 100) {
            comfort = "Economy class";
            switch (season) {
                case "Summer":
                    type = "Cabrio";
                    priceCar = budget * 0.35;
                    break;
                case "Winter":
                    type = "Jeep";
                    priceCar = budget * 0.65;
                    break;
            }
        } else if (budget > 100 && budget <= 500) {
            comfort = "Compact class";
            switch (season) {
                case "Summer":
                    type = "Cabrio";
                    priceCar = budget * 0.45;
                    break;
                case "Winter":
                    type = "Jeep";
                    priceCar = budget * 0.80;
                    break;
            }
        } else {
            comfort = "Luxury class";
            type = "Jeep";
            priceCar = budget * 0.90;
        }
        System.out.printf("%s", comfort);
        System.out.println("");
        System.out.printf("%s - %.2f", type, priceCar);
    }
}
