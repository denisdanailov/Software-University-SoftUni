package MockExamsPB.July2020;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());

        int firstStart = start / 1000;
        int secondStart = (start / 100) % 10;
        int thirdStart = (start / 10) % 10;
        int lastStart = start % 10;

        int firstEnd = end / 1000;
        int secondEnd = (end / 100) % 10;
        int thirdEnd = (end / 10) % 10;
        int lastEnd = end % 10;

        for (int num1 = firstStart; num1 <= firstEnd; num1++) {
            for (int num2 = secondStart; num2 <= secondEnd; num2++) {
                for (int num3 = thirdStart; num3 <= thirdEnd; num3++) {
                    for (int num4 = lastStart; num4 <= lastEnd; num4++) {
                        if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 != 0 && num4 % 2 != 0) {
                            System.out.printf("%d%d%d%d ", num1, num2, num3, num4);
                        }
                    }
                }
            }
        }
    }
}
