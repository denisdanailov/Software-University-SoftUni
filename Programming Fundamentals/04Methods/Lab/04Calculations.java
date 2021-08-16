package Methods.Labs;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String method = scan.nextLine();
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        int result = 0;

        switch (method) {
            case "add":
                result = add(num1, num2);
                break;
            case "multiply":
                result = multiply(num1, num2);
                break;
            case "subtract":
                result = subtract(num1, num2);
                break;
            case "divide":
                result = divide(num1, num2);
                break;
        }

        System.out.println(result);
    }

    public static int add(int num1, int num2) {
        return num1+num2;
    }
    public static int multiply(int num1, int num2) {
        return num1*num2;
    }
    public static int subtract(int num1, int num2) {
        if (num1 > num2) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }
    public static int divide(int num1, int num2) {
        if (num1 > num2) {
            return num1 / num2;
        } else {
            return num2 / num1;
        }
    }
}
