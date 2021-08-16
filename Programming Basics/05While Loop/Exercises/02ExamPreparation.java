package WhileLoop.Exercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int badGrade = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        String excName = "";
        int grade = 0;
        int countExc = 0;
        int countBadGrade = 0;
        double sum = 0;

        while (!input.equals("Enough")) {
            excName = input ;
            countExc++;
            grade = Integer.parseInt(scan.nextLine());

            if (grade <= 4) {
                countBadGrade++;
            }
            if (countBadGrade >= badGrade) {
                break;
            }

            sum += grade;

            input = scan.nextLine();

        }

        double averageScore = sum / countExc;

        if (input.equals("Enough")) {
            System.out.printf("Average score: %.2f%n", averageScore);
            System.out.printf("Number of problems: %d%n", countExc);
            System.out.printf("Last problem: %s", excName);
        } else {
            System.out.printf("You need a break, %d poor grades.", countBadGrade);
        }
    }
}
