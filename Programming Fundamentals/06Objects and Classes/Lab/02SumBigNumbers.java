package ObjectsAndClasses.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger firstInt = new BigInteger(scan.nextLine());
        BigInteger secondInt = new BigInteger(scan.nextLine());

        BigInteger sum = firstInt.add(secondInt);

        System.out.println(sum);

    }
}
