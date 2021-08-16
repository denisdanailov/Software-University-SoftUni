package NestedLoops.Exercises;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int num = 0;
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")) {
            num = Integer.parseInt(input);
            boolean isPrime = true;
            if (num < 0) {
                System.out.println("Number is negative.");
                input = scan.nextLine();
                continue;
            }

            for (int i = 2; i < num; i++) {

                if (num % i == 0) {
                    sumNonPrime += num;
                    isPrime = false;
                    break;
                }
            }

            if (isPrime && num!= 0 && num != 1) {
                sumPrime += num;
            }

            input = scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumNonPrime);
    }
}
