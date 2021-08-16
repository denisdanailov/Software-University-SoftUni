package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        double km = Double.parseDouble(scan.nextLine());

        double salary = 0;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (km <= 5000) {
                    salary = km * 0.75;
                } else if (km > 5000 && km <= 10000) {
                    salary = km * 0.95;
                } else if (km > 10000 && km <= 20000) {
                    salary = km * 1.45;
                }
                break;
            case "Summer":
                if (km <= 5000) {
                    salary = km * 0.90;
                } else if (km > 5000 && km <= 10000) {
                    salary = km * 1.10;
                } else if (km > 10000 && km <= 20000) {
                    salary = km * 1.45;
                }
                break;
            case "Winter":
                if (km <= 5000) {
                    salary = km * 1.05;
                } else if (km > 5000 && km <= 10000) {
                    salary = km * 1.25;
                } else if (km > 10000 && km <= 20000) {
                    salary = km * 1.45;
                }
                break;
        }
        double tax = salary * 0.10;
        double seasonalIncome = (salary * 4) - (tax * 4);

        System.out.printf("%.2f", seasonalIncome);
    }
}
