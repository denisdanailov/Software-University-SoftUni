package workingWithAbstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = readRhombusSides(scan);

        printRhombus(n);
    }

    private static void printRhombus(int n) {
        printRhombusFirstPart(n);
        printRhombusReversed(n);
    }

    private static int readRhombusSides(Scanner scan) {
        return Integer.parseInt(scan.nextLine());
    }

    private static void printRhombusReversed(int n) {
        for (int i = n - 1; i > 0; i--) {
            // Spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // '*'
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void printRhombusFirstPart(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // '*'
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
