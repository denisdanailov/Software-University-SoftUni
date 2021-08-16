package MockExamsPB.March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine();
        String set = scan.nextLine();
        int setNum = Integer.parseInt(scan.nextLine());

        double price = 0;
        double discount = 0;

        switch (fruit) {
            case "Watermelon":
                switch (set) {
                    case "small":
                        price = 56*2;
                        break;
                    case "big":
                        price = 28.70*5;
                        break;
                }
                break;
            case "Mango":
                switch (set) {
                    case "small":
                        price = 36.66*2;
                        break;
                    case "big":
                        price = 19.60*5;
                        break;
                }
                break;
            case "Pineapple":
                switch (set) {
                    case "small":
                        price = 42.10*2;
                        break;
                    case "big":
                        price = 24.80*5;
                        break;
                }
                break;
            case "Raspberry":
                switch (set) {
                    case "small":
                        price = 20*2;
                        break;
                    case "big":
                        price = 15.20*5;
                        break;
                }
                break;
        }
        price *= setNum;

        if (price >= 400 && price <= 1000) {
            discount = price * 0.15;
        } else if (price > 1000) {
            discount = price * 0.50;
        }

        price -= discount;

        System.out.printf("%.2f lv.", price);
    }
}
