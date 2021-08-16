package Methods.Labs;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num1 = Double.parseDouble(scan.nextLine());
        char operator = scan.nextLine().charAt(0);
        double num2 = Double.parseDouble(scan.nextLine());

        String pattern = "####";

        switch (operator) {
            case '*':
                System.out.println(new DecimalFormat(pattern).format(multiplyNumbers(num1, num2)));
                break;
            case '+':
                System.out.println(new DecimalFormat(pattern).format(sumNumbers(num1, num2)));
                break;
            case '-':
                System.out.println(new DecimalFormat(pattern).format(subtractNumbers(num1, num2)));
                break;
            case '/':
                System.out.println(new DecimalFormat(pattern).format(divideNumbers(num1, num2)));
                break;

        }
    }

    public static double multiplyNumbers(double a, double b) {
        return a * b;
    }

    public static double sumNumbers(double a, double b) {
        return a+ b;
    }

    public static double subtractNumbers(double a, double b) {
        return a - b;
    }

    public static double divideNumbers(double a, double b) {
        return a / b;
    }
}
