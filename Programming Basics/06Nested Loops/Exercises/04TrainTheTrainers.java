package NestedLoops.Exercises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double n = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        String name = "";
        double mark = 0;
        double sumAverage = 0;
        double countAverage = 0;

        while (!input.equals("Finish")){
            name = input;
            double sum = 0;
            for (int i = 0; i < n; i++) {
                mark = Double.parseDouble(scan.nextLine());
                sum += mark;
            }
            double average = sum / n;
            sumAverage += average;
            countAverage++;
            System.out.printf("%s - %.2f.%n", name, average);
            input = scan.nextLine();
        }
        double newAverage = sumAverage / countAverage;
        System.out.printf("Student's final assessment is %.2f.", newAverage);
    }
}
