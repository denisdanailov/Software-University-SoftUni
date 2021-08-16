package WhileLoop.Labs;

import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int i = 1;

        while (i <= n) {
            System.out.println(i);
            i = (i * 2) + 1;
        }
    }
}
