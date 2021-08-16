package NestedLoops.Exercises;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int n = Integer.parseInt(scan.nextLine());
            int l = Integer.parseInt(scan.nextLine());

        for (int num1 = 1; num1 <= n; num1++) {
            for (int num2 = 1; num2 <= n; num2++) {
                for (int num3 = 'a'; num3 < 'a'+l; num3++) {
                    char symbol = (char)num3;
                    for (int num4 = 'a'; num4 < 'a'+l; num4++) {
                        char symbol1 = (char)num4;
                        for (int num5 = 1; num5 <= n; num5++) {
                            if (num5 > num1  && num5 > num2) {
                                System.out.printf("%d%d%c%c%d ", num1, num2, symbol, symbol1, num5);
                            }
                        }
                    }
                }
            }
        }
    }
}
