package BasicSyntaxConditionalStatementsAndLoops.Labs;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int countOdd = 0;
        int sumOdd = 0;

        for (int i = 1; i <= 100; i++) {
            if (countOdd >= n) {
                break;
            }
            if (i % 2 != 0) {
                countOdd++;
                sumOdd += i;
                System.out.println(i);
            }
        }

        System.out.println("Sum: " + sumOdd);
    }
}
