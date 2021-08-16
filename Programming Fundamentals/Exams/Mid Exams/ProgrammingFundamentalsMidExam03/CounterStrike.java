package Exams.MidExam.ProgrammingFundamentalsMidExam03;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int energy = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        int countBattles = 0;
        int distance = 0;
        boolean lostBattle = false;

        while (!input.equals("End of battle")) {
            distance = Integer.parseInt(input);
            if (energy < distance) {
                lostBattle = true;
                break;
            }
            energy -= distance;
            countBattles += 1;
            if (countBattles % 3 == 0) {
                energy += countBattles;
            }
            input = scan.nextLine();
        }

        if (lostBattle) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", countBattles, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d%n",countBattles, energy);
        }
    }
}
