package ExamFebruary2021;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int locations = Integer.parseInt(scan.nextLine());




        for (int i = 0; i < locations; i++) {
          double expectedGoldAverage = Double.parseDouble(scan.nextLine());
          int days = Integer.parseInt(scan.nextLine());
          double totalGoldLocation = 0;
          double goldAverage = 0;
            for (int j = 0; j < days; j++) {
                double goldPerDay = Double.parseDouble(scan.nextLine());
                totalGoldLocation += goldPerDay;
            }
            goldAverage = totalGoldLocation / days;
            if (goldAverage >= expectedGoldAverage) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", goldAverage);
            } else {
                System.out.printf("You need %.2f gold.%n", Math.abs(goldAverage-expectedGoldAverage));
            }
        }
    }
}
