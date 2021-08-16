package Exams.MidExam.ProgrammingFundamentalsMidExam05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int students = Integer.parseInt(scan.nextLine());
        int lectures = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());

        double[] attendances = new double[students];
        for (int i = 0; i < attendances.length; i++) {
            double attendance = Double.parseDouble(scan.nextLine());
            attendances[i] = attendance;
        }

        double[] totalBonus = new double[students];
        for (int i = 0; i < totalBonus.length; i++) {
                totalBonus[i] = attendances[i] / lectures * (5 + bonus);
        }

        double maxBonus = Double.MIN_VALUE;
        double attendanceCount = 0;
        for (int i = 0; i < totalBonus.length; i++) {
            if (totalBonus[i] > maxBonus) {
                maxBonus = totalBonus[i];
                attendanceCount = attendances[i];
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %.0f lectures.", attendanceCount);
    }
}
