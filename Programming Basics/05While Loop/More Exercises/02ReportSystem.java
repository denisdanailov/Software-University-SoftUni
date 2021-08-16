package WhileLoop.MoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int expectedSum = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();
        String output = "";

        int sale = 0;
        int totalSum = 0;
        int count = 0;
        int ccPayment = 0;
        double sumCcPayment = 0;
        double ccPaymentCount = 0;
        int csPayment = 0;
        double sumCsPayment = 0;
        double csPaymentCount = 0;

        while (!input.equals("End")) {

            if (!input.equals("End")) {
                sale = Integer.parseInt(input);
            } else {
                break;
            }

            count++;

            if (count % 2 == 0) {
                ccPayment = sale;
                if (ccPayment >= 10) {
                    ccPaymentCount++;
                    sumCcPayment += ccPayment;
                    totalSum += sale;
                    output = "Product sold!";
                } else {
                    output = "Error in transaction!";
                }
            } else {
                csPayment = sale;
                if (csPayment <= 100) {
                    csPaymentCount++;
                    sumCsPayment += csPayment;
                    totalSum += sale;
                    output = "Product sold!";
                } else {
                    output = "Error in transaction!";
                }
            }

            System.out.println(output);

            if (totalSum >= expectedSum) {
                break;
            }

            input = scan.nextLine();
        }

        double averageCcPayment = sumCcPayment / ccPaymentCount;
        double averageCsPayment = sumCsPayment / csPaymentCount;

        if (totalSum >= expectedSum) {
            System.out.printf("Average CS: %.2f%n" + "Average CC: %.2f", averageCsPayment,  averageCcPayment);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
