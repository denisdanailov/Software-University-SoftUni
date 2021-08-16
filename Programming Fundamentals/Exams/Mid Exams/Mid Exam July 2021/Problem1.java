package Exams.MidExam.ProgrammingFundamentalsMidExamJuly21;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double foodKg = Double.parseDouble(scan.nextLine());
        double hayKg = Double.parseDouble(scan.nextLine());
        double coverKg = Double.parseDouble(scan.nextLine());
        double weightKg = Double.parseDouble(scan.nextLine());

        double foodGrams = foodKg * 1000;
        double hayGrams = hayKg * 1000;
        double coverGrams = coverKg * 1000;
        double weightGrams = weightKg * 1000;

        boolean foodNotEnough = false;
        boolean hayNotEnough = false;
        boolean coverNotEnough = false;
        int countDays = 0;

        for (int i = 0; i < 30; i++) {
            countDays += 1;
           foodGrams -= 300;
           if (foodGrams <= 0) {
               foodNotEnough = true;
               break;
           }
           if (countDays % 2 == 0) {
               hayGrams -= foodGrams * 0.05;
           }
            if (hayGrams <= 0) {
                hayNotEnough = true;
                break;
            }
           if (countDays % 3 == 0) {
               coverGrams -= weightGrams/3;
           }
            if (coverGrams <= 0) {
                coverNotEnough = true;
                break;
            }
        }

        if (!foodNotEnough && !hayNotEnough && !coverNotEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.02f, Hay: %.02f, Cover: %.02f.%n", foodGrams / 1000, hayGrams / 1000, coverGrams / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
