package Methods.Exercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input1 = Integer.parseInt(scan.nextLine());
        int input2 = Integer.parseInt(scan.nextLine());
        int input3 = Integer.parseInt(scan.nextLine());

        int sumOfFirstTwo = sumOfTwoNumbers(input1, input2);
        int finalResult = subtractTwoNumbers(sumOfFirstTwo, input3);

        System.out.println(finalResult);

//        System.out.println(subtractTwoNumbers(sumOfTwoNumbers(input1, input2),input3));
    }

    public static int sumOfTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtractTwoNumbers(int num1, int num2) {
        return num1 - num2;
    }
}
