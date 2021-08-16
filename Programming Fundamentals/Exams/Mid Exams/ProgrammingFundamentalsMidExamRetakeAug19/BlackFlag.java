package Exams.MidExam.ProgrammingFundamentalsMidExamRetakeAug19;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double totalPlunder =0;
        int daysCount = 0;

        for (int i = 0; i < daysOfPlunder; i++) {
            daysCount += 1;
            totalPlunder += dailyPlunder;
            if (daysCount % 3 == 0) {
                double additionalPlunder = dailyPlunder * 0.5;
                totalPlunder += additionalPlunder;
            }
            if (daysCount % 5 == 0) {
                double lostPlunder = totalPlunder * 0.30;
                totalPlunder -= lostPlunder;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.02f plunder gained.%n", totalPlunder);
        } else {
            double percentageLeft = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.02f%% of the plunder.%n", percentageLeft);
        }
    }
}
