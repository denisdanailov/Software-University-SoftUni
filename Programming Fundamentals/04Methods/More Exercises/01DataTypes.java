package Methods.MoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstLine = scan.nextLine();

        if (firstLine.equals("int")) {
            int number = Integer.parseInt(scan.nextLine());
            printOutput(number);
        } else if (firstLine.equals("real")) {
            double realNumber = Double.parseDouble(scan.nextLine());
            printOutput(realNumber);
        } else if (firstLine.equals("string")) {
            String secondLine = scan.nextLine();
            printOutput(secondLine);
        }


    }

    public static void printOutput(String input) {
        System.out.printf("$%s$", input);
    }

    public static void printOutput(double realNumber) {
        System.out.printf("%.02f", realNumber * 1.5);
    }

    public static void printOutput(int number) {
        System.out.println(number * 2);
    }
}
