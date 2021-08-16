package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double n1 = Double.parseDouble(scan.nextLine());
        double n2 = Double.parseDouble(scan.nextLine());
        char operator = scan.next().charAt(0);

        double result = 0;
        String evenOdd = "";

        switch (operator) {
            case '+':
                result = n1 + n2;
                if (result % 2 == 0) {
                    evenOdd = "even";
                } else {
                    evenOdd = "odd";
                }
                System.out.printf("%.0f %c %.0f = %.0f - %s", n1, operator, n2, result, evenOdd);
                break;
            case '-':
                result = n1 - n2;
                if (result % 2 == 0) {
                    evenOdd = "even";
                } else {
                    evenOdd = "odd";
                }
                System.out.printf("%.0f %c %.0f = %.0f - %s", n1, operator, n2, result, evenOdd);
                break;
            case '*':
                result = n1 * n2;
                if (result % 2 == 0) {
                    evenOdd = "even";
                } else {
                    evenOdd = "odd";
                }
                System.out.printf("%.0f %c %.0f = %.0f - %s", n1, operator, n2, result, evenOdd);
                break;
            case '/':
                if(n2 == 0) {
                    System.out.printf("Cannot divide %.0f by zero", n1);
                } else {
                    result = n1 / n2;
                    System.out.printf("%.0f %c %.0f = %.2f", n1, operator, n2, result);
                }
                break;
            case '%':
                if (n2 == 0) {
                    System.out.printf("Cannot divide %.0f by zero", n1);
                } else {
                    result = n1 % n2;
                    System.out.printf("%.0f %c %.0f = %.0f", n1, operator, n2, result);
                }
                break;
        }
    }
}
