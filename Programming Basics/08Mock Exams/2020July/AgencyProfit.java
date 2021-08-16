package MockExamsPB.July2020;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String companyName = scan.nextLine();
        int numAdultTickets = Integer.parseInt(scan.nextLine());
        int numKidsTickets = Integer.parseInt(scan.nextLine());
        double netAdultTicketPrice = Double.parseDouble(scan.nextLine());
        double tax = Double.parseDouble(scan.nextLine());

        double netKidTicketPrice = netAdultTicketPrice * 0.30;

        double adultTicketWithTax = netAdultTicketPrice + tax;
        double kidTicketWithTax = netKidTicketPrice + tax;

        double revenueTickets = (adultTicketWithTax * numAdultTickets) + (kidTicketWithTax * numKidsTickets);
        double profit = revenueTickets*0.20;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);
    }
}
