package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;
        double discountStudio = 0;
        double discountApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceStudio = 50;
                priceApartment = 65;
                if (nights > 7 && nights <= 14) {
                    discountStudio = priceStudio * 0.05;
                } else if (nights > 14) {
                    discountStudio = priceStudio * 0.30;
                    discountApartment = priceApartment * 0.10;
                }
                break;
            case "June":
            case "September":
                priceStudio = 75.20;
                priceApartment = 68.70;
                if (nights > 14) {
                    discountStudio = priceStudio * 0.20;
                    discountApartment = priceApartment * 0.10;
                }
                break;
            case "July":
            case "August":
                priceStudio = 76;
                priceApartment = 77;
                if (nights > 14) {
                    discountApartment = priceApartment * 0.10;
                }
                break;
        }
        double totalPriceStudio = (priceStudio - discountStudio) * nights;
        double totalPriceApartment = (priceApartment - discountApartment) * nights;

        System.out.printf("Apartment: %.2f lv.", totalPriceApartment);
        System.out.println("");
        System.out.printf("Studio: %.2f lv.", totalPriceStudio);
    }
}
