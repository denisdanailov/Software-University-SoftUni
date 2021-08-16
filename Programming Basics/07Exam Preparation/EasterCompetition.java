package PreExamPreparation;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bread = Integer.parseInt(scan.nextLine());

        String bestBaker = "";
        int bestScore = 0;

        for (int i = 0; i < bread; i++) {

            String bakerName = scan.nextLine();
            String input = scan.nextLine();
            int score = 0;
            int sumScore = 0;

            while (!input.equals("Stop")) {
                score = Integer.parseInt(input);
                sumScore += score;

                input= scan.nextLine();
            }

            System.out.printf("%s has %d points.%n", bakerName, sumScore);

            if (sumScore > bestScore) {
                    bestScore = sumScore;
                    bestBaker = bakerName;
                    System.out.printf("%s is the new number 1!%n", bestBaker);
               }

        }

        System.out.printf("%s won competition with %d points!%n", bestBaker, bestScore);

    }
}
