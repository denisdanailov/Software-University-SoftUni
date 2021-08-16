package MockExamsPB.July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceLuggageMoreThan20Kg = Double.parseDouble(scan.nextLine());
        double luggageKg = Double.parseDouble(scan.nextLine());
        int daysToDeparture = Integer.parseInt(scan.nextLine());
        int luggageAmount = Integer.parseInt(scan.nextLine());

        double priceLuggage = 0;

        if (luggageKg < 10) {
            priceLuggage = priceLuggageMoreThan20Kg * 0.20;
        } else if (luggageKg >= 10 && luggageKg <= 20) {
            priceLuggage = priceLuggageMoreThan20Kg * 0.50;
        } else if (luggageKg > 20) {
            priceLuggage = priceLuggageMoreThan20Kg;
        }

        if (daysToDeparture > 30) {
            priceLuggage += priceLuggage * 0.10;
        } else if (daysToDeparture >= 7) {
            priceLuggage += priceLuggage * 0.15;
        } else {
            priceLuggage += priceLuggage * 0.40;
        }

        double totalPrice = priceLuggage * luggageAmount;

        System.out.printf("The total price of bags is: %.2f lv. ", totalPrice);
    }
}
