package DataTypesAndVariables.Labs;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pound = Integer.parseInt(scan.nextLine());

        double dollars = pound * 1.31;

        System.out.printf("%.03f",dollars);
    }
}
