package FirstStepsInCoding.Labs;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double squareMetre = Double.parseDouble(scan.nextLine());

        Double jobPrice = squareMetre * 7.61;
        Double discount = jobPrice * 0.18;
        Double finalPrice = jobPrice - discount;

        System.out.println("The final price is: " + finalPrice + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}
