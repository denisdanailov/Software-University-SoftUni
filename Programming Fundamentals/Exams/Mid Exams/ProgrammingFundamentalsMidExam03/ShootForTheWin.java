package Exams.MidExam.ProgrammingFundamentalsMidExam03;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();

        int countShotTarget = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            int shotValue = 0;
            if (index < targets.length) {
                countShotTarget += 1;
                shotValue = targets[index];
                targets[index] = -1;
            }
            for (int i = 0; i < targets.length; i++) {
              if (targets[i] != -1) {
                  if (targets[i] > shotValue) {
                      targets[i] -= shotValue;
                  } else {
                      targets[i] += shotValue;
                  }
              }
            }
            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShotTarget);
        for (int target:
             targets) {
            System.out.print( target + " ");
        }
    }
}
