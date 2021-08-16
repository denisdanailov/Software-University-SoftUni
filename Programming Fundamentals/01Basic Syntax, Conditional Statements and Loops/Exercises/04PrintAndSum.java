package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int finish = Integer.parseInt(scan.nextLine());

        int sum = 0;

        for (int i = start; i <= finish; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("");
        System.out.printf("Sum: %d", sum);
    }
}
