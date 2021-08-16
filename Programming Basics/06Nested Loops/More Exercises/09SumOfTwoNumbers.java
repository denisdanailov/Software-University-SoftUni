package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());

        int count = 0;
        int countMagic = 0;
        boolean flag = false;
        int num1 = 0;
        int num2 = 0;
        boolean firstMatch = true;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                count++;
                if (i+j == magicNumber && firstMatch) {
                        firstMatch = false;
                        countMagic = count;
                        num1 = i;
                        num2 = j;
                        flag = true;
                }
            }
        }
        if (flag) {
            System.out.printf("Combination N:%d (%d + %d = %d)", countMagic, num1, num2, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}
