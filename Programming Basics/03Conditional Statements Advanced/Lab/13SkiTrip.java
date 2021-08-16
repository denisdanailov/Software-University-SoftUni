package AdvConditionalStatements.Labs;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String roomType = scan.nextLine();
        String experience = scan.nextLine();

        int nights = days - 1;
        double priceStay = 0;
        double discount = 0;

        switch (roomType) {
            case "room for one person":
                priceStay = nights * 18.00;
                discount = 0;
                break;
            case "apartment":
                priceStay = nights * 25.00;
                if (days < 10) {
                    discount = priceStay * 0.30;
                } else if (days >= 10 && days <= 15) {
                    discount = priceStay * 0.35;
                } else if (days > 15) {
                    discount = priceStay * 0.50;
                }
                break;
            case "president apartment":
                priceStay = nights * 35.00;
                if (days < 10) {
                    discount = priceStay * 0.10;
                } else if (days >= 10 && days <= 15) {
                    discount = priceStay * 0.15;
                } else if (days > 15) {
                    discount = priceStay * 0.20;
                }
                break;
        }

        priceStay = priceStay - discount;

        if (experience.equals("positive")) {
            priceStay += priceStay * 0.25;
        } else if (experience.equals("negative")) {
            priceStay -= priceStay * 0.1;
        }
        System.out.printf("%.2f", priceStay);
    }
}
