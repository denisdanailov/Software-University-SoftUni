package TextProcessing.Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        BigInteger num = new BigInteger(scan.nextLine());
//        BigInteger n = new BigInteger(scan.nextLine());
//        BigInteger sum = num.multiply(n);

        String num = scan.nextLine().replaceFirst("^0+", "");
        int n = Integer.parseInt(scan.nextLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int carry = 0;
        StringBuilder sum = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            int result = n * digit + carry;
            int addDigit = result % 10;
            carry = result / 10;

            if (i == 0) {
                sum.insert(0, result);
            } else {
                sum.insert(0, addDigit);
            }
        }
        System.out.println(sum);
    }
}
