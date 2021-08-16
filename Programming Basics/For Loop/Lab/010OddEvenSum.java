package ForLoop.Labs;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if(i % 2 == 0){
                sum1 += num;
            } else {
                sum2 += num;
            }
        }

        if (sum1 == sum2) {
            System.out.printf("Yes%n");
            System.out.printf("Sum = %d", sum1);
        } else {
            System.out.printf("No%n");
            System.out.printf("Diff = %d", Math.abs(sum1 - sum2));
        }
    }
}
