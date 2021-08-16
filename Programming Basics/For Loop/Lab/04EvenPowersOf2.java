package ForLoop.Labs;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int result = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                result = (int) Math.pow(2, i);
                System.out.println(result);
            }
        }
    }
}
