package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int bakers = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int waffles = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());

        Double priceCakes = 45.00;
        Double priceWaffle = 5.80;
        Double pricePancakes = 3.20;

        Double totalSumCake = cakes * priceCakes;
        Double totalSumWaffle = waffles * priceWaffle;
        Double totalSumPancake = pancakes * pricePancakes;

        Double totalSumPerDay = (totalSumCake + totalSumWaffle + totalSumPancake ) * bakers;
        Double totalSumCampaign = totalSumPerDay * days;
        Double totalSumAfterExpenses = totalSumCampaign - (totalSumCampaign * 1/8);

        System.out.printf("%.2f",totalSumAfterExpenses);

    }
}
