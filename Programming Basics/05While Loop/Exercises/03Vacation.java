package WhileLoop.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scan.nextLine());
        double cash = Double.parseDouble(scan.nextLine());

        String action = "";
        double sum = 0;

        int spendCount = 0;
        int daysCount = 0;

        while (cash < vacationPrice) {

            action = scan.nextLine();
            sum = Double.parseDouble(scan.nextLine());
            daysCount++;

            switch (action) {
                case "spend":
                    spendCount++;
                    cash -= sum;
                    if (cash <= 0) {
                        cash = 0;
                    }
                    break;
                case "save":
                    spendCount = 0;
                    cash += sum;
                    break;
            }

            if (spendCount >= 5) {
                break;
            }

        }

        if (spendCount >= 5) {
           System.out.println("You can't save the money.");
           System.out.printf("%d", daysCount);
        } else if (cash >= vacationPrice) {
            System.out.printf("You saved the money for %d days.", daysCount);
        }
    }
}
