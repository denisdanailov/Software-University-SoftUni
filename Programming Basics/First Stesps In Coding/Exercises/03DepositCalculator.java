package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double deposit = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        Double interest = Double.parseDouble(scan.nextLine());

        Double interestRate = deposit * interest / 100;
        Double interestRateMonth = (deposit * interest /100) /12;
        Double sum = deposit + months * interestRateMonth;

        System.out.println(sum);
    }
}
