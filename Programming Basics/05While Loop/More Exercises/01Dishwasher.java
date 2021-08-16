package WhileLoop.MoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bottles = Integer.parseInt(scan.nextLine());
        int liquidDW = bottles * 750;

        String input = "";
        int dishes = 0;
        int sumPlates = 0;
        int sumSaucepans = 0;
        int count = 0;

        while (liquidDW >= 0) {
            count++;

            input = scan.nextLine();

            if (!input.equals("End")) {
                dishes = Integer.parseInt(input);
            } else {
                break;
            }

            if (count % 3 == 0) {
                sumSaucepans += dishes;
                dishes = dishes * 15;
            } else {
                sumPlates += dishes;
                dishes = dishes * 5;
            }

            liquidDW -= dishes;
        }

        if (liquidDW < 0) {
            int diff = Math.abs(liquidDW);
            System.out.printf("Not enough detergent, %d ml. more necessary!", diff);
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", sumPlates, sumSaucepans);
            System.out.printf("Leftover detergent %d ml.", liquidDW);
        }
    }
}
