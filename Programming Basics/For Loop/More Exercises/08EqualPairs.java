package ForLoop.MoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;
        int lastSum = 0;
        int diff = 0;

        for (int i = 1; i <= n; i++) {

            int num1 = Integer.parseInt(scan.nextLine());
            int num2 = Integer.parseInt(scan.nextLine());

            sum = num1 + num2;

            if (i > 1 && lastSum != sum) {
                diff = Math.abs(lastSum - sum);
            }

            lastSum = sum;
        }

        if (diff != 0) {
            System.out.printf("No, maxdiff=%d", diff);
        } else {
            System.out.printf("Yes, value=%d", sum);
        }

    }
}
