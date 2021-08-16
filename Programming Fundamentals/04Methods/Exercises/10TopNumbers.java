package Methods.Exercises;

import java.util.Scanner;

public class topNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        printTopNumbers(n);
    }

    public static void printTopNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            int counter = 0;
            int counterValue = i;
            int sumDigits = 0;
            int copyValue1 = i;
            int copyValue2 = i;

            while (!(counterValue == 0)) {
                counterValue /= 10;
                counter++;
            }

            for (int j = 0; j < counter; j++) {
                sumDigits += copyValue1 % 10;
                copyValue1 /= 10;
            }

            boolean isTopNumber = false;
            if (sumDigits % 8 == 0) {
                int digit = 0;
                for (int j = 0; j < counter; j++) {
                    digit = copyValue2 % 10;
                    copyValue2 /= 10;
                    if (digit % 2 != 0) {
                        isTopNumber = true;
                        break;
                    }
                }
                if (isTopNumber) {
                    System.out.println(i);
                }
            }
        }
    }

}
