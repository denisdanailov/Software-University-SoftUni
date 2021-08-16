package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceLightsabers = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());

        double totalPrice = (priceLightsabers*students) + (priceRobes*students) + (priceBelts*students);
        totalPrice += Math.ceil(students* 0.10)*priceLightsabers;
        totalPrice -= (students/6)*priceBelts;
        if (budget >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.02flv.", totalPrice);
        } else if (budget <= totalPrice) {
            System.out.printf("Ivan Cho will need %.02flv more.", Math.abs(totalPrice-budget));
        }
    }
}
