package Methods.Exercises;

import java.util.Scanner;

public class NxnMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        printNxnMatrix(number);
    }

    public static void printNxnMatrix(int number) {
        for (int i = 0; i < number; i++) {
            printNxnMatrixRow(number);
            System.out.println();
        }
    }

    public static void printNxnMatrixRow(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(number + " ");
        }
    }
}
