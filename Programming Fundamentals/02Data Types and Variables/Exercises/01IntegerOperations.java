package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int fourth = Integer.parseInt(scan.nextLine());

        int sum = first + second;
        sum = sum/third;
        sum = sum*fourth;

        System.out.println(sum);
    }
}

