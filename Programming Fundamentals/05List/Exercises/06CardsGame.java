package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int firstCard = firstDeck.get(0);
            int secondCard = secondDeck.get(0);

                if (firstCard > secondCard) {
                    secondDeck.remove(0);
                    firstDeck.remove(0);
                    firstDeck.add(firstCard);
                    firstDeck.add(secondCard);
                } else if (firstCard < secondCard) {
                    secondDeck.remove(0);
                    firstDeck.remove(0);
                    secondDeck.add(secondCard);
                    secondDeck.add(firstCard);
                } else if (firstCard == secondCard) {
                    secondDeck.remove(0);
                    firstDeck.remove(0);
            }
        }

        boolean flag = false;
        int sum1 = 0;
        int sum2 = 0;

        if (!firstDeck.isEmpty()) {
            for (int number:
                 firstDeck) {
                sum1 += number;
                flag = true;
            }
        } else {
            for (int number :
                    secondDeck) {
                sum2 += number;
            }
        }

        if (flag) {
            System.out.println("First player wins! Sum: " + sum1);
        } else {
            System.out.println("Second player wins! Sum: " + sum2);
        }
    }
}
