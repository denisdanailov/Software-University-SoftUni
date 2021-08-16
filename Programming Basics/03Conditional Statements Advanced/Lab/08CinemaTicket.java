package AdvConditionalStatements.Labs;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String day = scan.nextLine();

        int priceTicket = 0;

        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Friday")) {
            priceTicket = 12;
        } else if (day.equals("Wednesday") || day.equals("Thursday")) {
            priceTicket = 14;
        } else if (day.equals("Saturday") || day.equals("Sunday")) {
            priceTicket = 16;
        }
        System.out.println(priceTicket);
    }
}
