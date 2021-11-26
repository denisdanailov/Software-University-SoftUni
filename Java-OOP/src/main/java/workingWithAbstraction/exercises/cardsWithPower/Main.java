package workingWithAbstraction.exercises.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();

        int cardPow = Card.calcPower(rank, suit);

        System.out.printf("Card name: %S of %s; Card power: %d%n", rank, suit, cardPow);
    }
}
