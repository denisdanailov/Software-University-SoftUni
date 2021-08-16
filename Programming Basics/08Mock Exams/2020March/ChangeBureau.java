package MockExamsPB.March2020;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scan.nextLine());
        double yuan = Double.parseDouble(scan.nextLine());
        double commissionPercent = Double.parseDouble(scan.nextLine());

        double bitcoinLeva = bitcoin * 1168;
        double yuanDollars = yuan * 0.15;
        double dollarsLeva = yuanDollars * 1.76;
        double euro = (bitcoinLeva + dollarsLeva) / 1.95;
        double commission = euro * (commissionPercent/100);
        euro -= commission;

        System.out.printf("%.2f", euro);
    }
}
