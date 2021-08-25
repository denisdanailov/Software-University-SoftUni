package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readSetFromConsole(scan);
        LinkedHashSet<Integer> secondDeck = readSetFromConsole(scan);

        int rounds = 0;
        while (!firstDeck.isEmpty() || !secondDeck.isEmpty()) {
            rounds++;
            if (rounds > 50) {
                break;
            }
            int firstCard = firstDeck.iterator().next();
            int secondCard = secondDeck.iterator().next();
            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);
            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }

        String output = checkOutput(firstDeck, secondDeck);
        System.out.println(output);
    }

    private static String checkOutput(LinkedHashSet<Integer> firstDeck,LinkedHashSet<Integer> secondDeck) {
        String output = "";
        if (firstDeck.size() > secondDeck.size()) {
            output = "First player win!";
        } else if (firstDeck.size() < secondDeck.size()) {
            output = "Second player win!";
        } else { // if firstDeck == secondDeck
            output = "Draw!";
        }
        return output;
    }

    private static LinkedHashSet<Integer> readSetFromConsole(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
