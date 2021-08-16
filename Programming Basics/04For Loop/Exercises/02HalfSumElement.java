package ForLoop.Exercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            sum += num;

            if (maxNumber < num) {
                maxNumber = num;
            }
        }
        sum -= maxNumber;
        if (maxNumber == sum) {
            System.out.printf("Yes%n");
            System.out.printf("Sum = %d", sum);
        } else {
            System.out.printf("No%n");
            System.out.printf("Diff = %d", Math.abs(sum - maxNumber));
        }
    }
}
