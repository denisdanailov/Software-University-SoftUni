package BasicSyntaxConditionalStatementsAndLoops.Labs;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int product;

        for (int i = 1; i <= 10; i++) {
            product = num * i;
            System.out.println (num +" X "+ i +" = " + product);
        }
    }
}
