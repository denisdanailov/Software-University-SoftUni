package ForLoop.Labs;

import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceWM = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        int moneybd = 0;
        int sumToy = 0;
        int taxBrother = 0;
        int sumMoney = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                taxBrother += 1;
                moneybd += 10;
                sumMoney += moneybd;
            } else {
                sumToy += 1;
            }
        }
        int moneyToys = sumToy * toyPrice;
        sumMoney -= taxBrother;

        int allMoney = sumMoney + moneyToys;

        if (allMoney >= priceWM){
            System.out.printf("Yes! %.2f", (allMoney - priceWM));
        } else {
            System.out.printf("No! %.2f", (priceWM - allMoney));
        }
    }
}
