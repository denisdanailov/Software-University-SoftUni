package PreExamPreparation;

import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int staff = Integer.parseInt(scan.nextLine());
        double entranceFee = Double.parseDouble(scan.nextLine());
        double sunbedPrice = Double.parseDouble(scan.nextLine());
        double umbrellaPrice = Double.parseDouble(scan.nextLine());

        double totalEntranceFee = staff * entranceFee;
        double totalSunbedPrice = sunbedPrice * Math.ceil(staff * 0.75);
        double totalUmbrellaPrice = umbrellaPrice * Math.ceil(staff * 0.50);

        double totalPrice = totalEntranceFee + totalSunbedPrice + totalUmbrellaPrice;

        System.out.printf("%.2f lv.", totalPrice);
    }
}
