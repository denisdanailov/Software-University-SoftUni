package ForLoop.MoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double averageExpenses = 0;
        double sumElectricity = 0;
        double water = 0;
        double internet = 0;
        double other = 0;

        for (int i = 0; i < n; i++) {

            double electricity = Double.parseDouble(scan.nextLine());
            sumElectricity += electricity;
            water += 20;
            internet += 15;
            other += electricity + 20 + 15 + ((electricity + 20 + 15) * 0.20);
        }
        averageExpenses = (sumElectricity + water + internet + other) / n;

        System.out.printf("Electricity: %.2f lv%n", sumElectricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", other);
        System.out.printf("Average: %.2f lv%n", averageExpenses);
    }
}
