package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

      String input = scan.nextLine();

      int digit = 0;
      int totalSum = 0;

        for (int i = 0; i < input.length(); i++) {
            int sumFact = 1;
          digit = (input.charAt(i)) - 48;
            for (int j = 1; j <= digit; j++) {
                sumFact *= j;
            }
            totalSum += sumFact;
        }

        int num = Integer.parseInt(input);
        if (totalSum == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
