package ForLoop.MoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double countTop = 0;
        double countFour = 0;
        double countThree = 0;
        double countFail = 0;

        int countGrade =0;
        double sumTop = 0;
        double sumFour = 0;
        double sumThree = 0;
        double sumFail = 0;

        for (int i = 0; i < n; i++) {

            double grade = Double.parseDouble(scan.nextLine());

            countGrade++;

            if (grade >= 2.00 && grade <= 2.99) {
                countFail++;
                sumFail += grade;
            } else if (grade >= 3.00 && grade <= 3.99) {
                countThree++;
                sumThree += grade;
            } else if (grade >= 4.00 && grade <= 4.99) {
                countFour++;
                sumFour += grade;
            } else if (grade >= 5.00){
                countTop++;
                sumTop += grade;
            }
        }
        double averageGrade = (sumFail+sumThree+sumFour+sumTop)/ countGrade;

        double percentageTop = (countTop/countGrade) *100;
        double percentageFour = (countFour/countGrade) *100;
        double percentageThree = (countThree/countGrade) *100;
        double percentageFail = (countFail/countGrade) *100;

        System.out.printf("Top students: %.2f%%%n", percentageTop);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentageFour);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentageThree);
        System.out.printf("Fail: %.2f%%%n", percentageFail);
        System.out.printf("Average: %.2f%n", averageGrade);
    }
}
