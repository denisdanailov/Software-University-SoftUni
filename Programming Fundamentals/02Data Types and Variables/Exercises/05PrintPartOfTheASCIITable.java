package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int finish = Integer.parseInt(scan.nextLine());

        for (int i = start; i <= finish; i++) {
            char output = (char)i;
            System.out.print(output + " ");
        }
    }
}
