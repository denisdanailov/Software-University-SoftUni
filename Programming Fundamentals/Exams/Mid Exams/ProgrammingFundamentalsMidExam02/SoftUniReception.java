package Exams.MidExam.ProgrammingFundamentalsMidExam02;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scan.nextLine());
        int secondEmployee = Integer.parseInt(scan.nextLine());
        int thirdEmployee = Integer.parseInt(scan.nextLine());

        int queryCount = Integer.parseInt(scan.nextLine());

        int queriesPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int hoursNeeded = 0;
        while (queryCount > 0) {
            hoursNeeded += 1;
            if (hoursNeeded % 4 != 0) {
                queryCount -= queriesPerHour;
            }
        }

        System.out.printf("Time needed: %dh.%n", hoursNeeded);
    }
}
