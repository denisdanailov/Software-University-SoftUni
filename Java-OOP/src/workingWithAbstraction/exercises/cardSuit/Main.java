package workingWithAbstraction.exercises.cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        // Create array from enum Class
        CardSuits[] suits = CardSuits.values();

        // Print
        System.out.println("Card Suits:");
        for (CardSuits card : suits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
