package WhileLoop.Exercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int steps = 0;
        int sumSteps = 0;
        int diff = 0;
        int stepsToHome = 0;

        while (!input.equals("Going home")) {

            if (!input.equals("Going home")) {
                steps = Integer.parseInt(input);
            }

            sumSteps += steps;

            if (sumSteps >= 10000) {
                break;
            }

            input = scan.nextLine();
        }

        if (input.equals("Going home")) {
            stepsToHome = Integer.parseInt(scan.nextLine());
            sumSteps += stepsToHome;
        }

        if (sumSteps >= 10000) {
            diff = sumSteps - 10000;
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", diff);
        } else {
            diff = sumSteps - 10000;
            System.out.printf("%d more steps to reach goal.", Math.abs(diff));
        }
    }
}
