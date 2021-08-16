package Methods.Labs;

import java.util.Scanner;

public class MultiplyEvensByOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(getMultipleOfEvenAndOdd(n));
    }

    public static int getMultipleOfEvenAndOdd(int n){
        return sumOddDigits(n) * sumEvenDigits(n);
    }

    public static int sumOddDigits(int n){
        int digit;
        int sumDigit = 0;

        while (n!=0) {
            digit = n % 10;
            if (digit % 2 != 0) {
                sumDigit += Math.abs(digit);
            }
            n /= 10;
        }
        return sumDigit;
    }

    public static int sumEvenDigits(int n){
        int digit;
        int sumDigit = 0;

        while (n!=0) {
            digit = n % 10;
            if (digit % 2 == 0) {
                sumDigit += Math.abs(digit);
            }
            n /= 10;
        }
        return sumDigit;
    }
}
