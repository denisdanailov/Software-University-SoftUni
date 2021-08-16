package AdvConditionalStatements.Labs;

import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        boolean invalid = num >= 100 && num <= 200 || num == 0;

        if (!invalid) {
            System.out.println("invalid");
        }
    }
}
