package DataTypesAndVariables.Labs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal("0");

        for (int i = 0; i < n; i++) {
            BigDecimal newInt = scan.nextBigDecimal();
            sum = sum.add(newInt);
        }

        System.out.println(sum);
    }
}
