package MockExamsPB.July2020;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String name = "";
        int goals = 0;

        int mostGoals = 0;
        String bestPlayer = "";

        while (!input.equals("END")) {
            name = input;
            goals = Integer.parseInt(scan.nextLine());

            if (goals > mostGoals) {
                mostGoals = goals;
                bestPlayer = name;
            }

            if (goals >= 10) {
                break;
            }

            input = scan.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);
        if (mostGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", mostGoals);
        } else {
            System.out.printf("He has scored %d goals.", mostGoals);
        }
    }
}
