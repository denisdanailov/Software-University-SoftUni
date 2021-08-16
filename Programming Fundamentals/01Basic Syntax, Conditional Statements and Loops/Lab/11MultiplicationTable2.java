package BasicSyntaxConditionalStatementsAndLoops.Labs;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        int product;

        if (b <= 10) {
            for (int i = b; i <= 10; i++) {
                product = a * i;
                System.out.println(a + " X " + i + " = " + product);
            }
        } else {
            product = a * b;
            System.out.println(a + " X " + b + " = " + product);
        }
    }
}
