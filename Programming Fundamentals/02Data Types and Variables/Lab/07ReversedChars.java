package DataTypesAndVariables.Labs;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char input1 = scan.nextLine().charAt(0);
        char input2 = scan.nextLine().charAt(0);
        char input3 = scan.nextLine().charAt(0);

        System.out.println(input3+" "+input2+" "+input1);
    }
}
