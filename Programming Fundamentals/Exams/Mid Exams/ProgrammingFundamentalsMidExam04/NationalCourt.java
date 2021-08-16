package Exams.MidExam.ProgrammingFundamentalsMidExam04;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmpProduct = Integer.parseInt(scan.nextLine());
        int secondEmpProduct = Integer.parseInt(scan.nextLine());
        int thirdEmpProduct = Integer.parseInt(scan.nextLine());
        int questionsToBeServiced = Integer.parseInt(scan.nextLine());

        int questionsPerHour = firstEmpProduct + secondEmpProduct + thirdEmpProduct;
        int countHours = 0;

        while (questionsToBeServiced > 0) {
            if (countHours % 4 != 0) {
                questionsToBeServiced -= questionsPerHour;
            }
            if (questionsToBeServiced > 0) {
                countHours += 1;
            }
        }

        System.out.printf("Time needed: %dh.%n", countHours);
    }
}
