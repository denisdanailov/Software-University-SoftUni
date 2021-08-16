package AdvConditionalStatements.Labs;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String city = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());

        double commission = 0;
        String output = "";

        switch (city) {
            case "Sofia":
                if(sales >= 0 && sales <= 500) {
                    commission = sales * 0.05;
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * 0.07;
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * 0.08;
                } else if (sales > 10000) {
                    commission = sales * 0.12;
                } else {
                    output = "error";
                    System.out.println(output);
                }
                break;
            case "Varna":
                if(sales >= 0 && sales <= 500) {
                    commission = sales * 0.045;
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * 0.075;
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * 0.1;
                } else if (sales > 10000) {
                    commission = sales * 0.13;
                } else {
                    output = "error";
                    System.out.println(output);
                }
                break;
            case "Plovdiv":
                if(sales >= 0 && sales <= 500) {
                    commission = sales * 0.055;
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * 0.08;
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * 0.12;
                } else if (sales > 10000) {
                    commission = sales * 0.145;
                } else {
                    output = "error";
                    System.out.println(output);
                }
                break;
            default:
                output = "error";
                System.out.println(output);
        }
        if (!output.equals("error")) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("");
        }
    }
}
