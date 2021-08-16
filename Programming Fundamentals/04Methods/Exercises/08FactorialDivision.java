package Methods.Exercises;

import java.util.Scanner;

public class factorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input1 = Integer.parseInt(scan.nextLine());
        int input2 = Integer.parseInt(scan.nextLine());

        double firstResult = factorial(input1);
        double secondResult = factorial(input2);

        System.out.printf("%.02f",Math.abs(firstResult/secondResult));
    }

    public static long factorial(int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
