package NestedLoops.Labs;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());

        int count = 0;
        boolean flag = false;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                int sum = i + j;
                count++;
                if (i + j == magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, sum   );
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}
