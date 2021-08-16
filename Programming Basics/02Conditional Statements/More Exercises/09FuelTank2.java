package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fuel = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        String membershipCard = scan.nextLine();
        //Решения
        double priceDiesel = 2.33;
        double priceGasoline = 2.22;
        double priceGas = 0.93;
        double fuelPrice = 0;

        if (membershipCard.equals("Yes")) {
            if (fuel.equals("Diesel")) {
                fuelPrice = (priceDiesel - 0.12) * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            } else if (fuel.equals("Gasoline")) {
                fuelPrice = (priceGasoline - 0.18) * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            } else if (fuel.equals("Gas")) {
                fuelPrice = (priceGas - 0.08) * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            }
        } else if (membershipCard.equals("No")) {
            if (fuel.equals("Diesel")) {
                fuelPrice = priceDiesel * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            } else if (fuel.equals("Gasoline")) {
                fuelPrice = priceGasoline * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            } else if (fuel.equals("Gas")) {
                fuelPrice = priceGas * quantity;
                if (quantity >= 20 && quantity <= 25) {
                    fuelPrice -= fuelPrice * 0.08;
                } else if (quantity > 25) {
                    fuelPrice *= 0.90;
                }
            }
        }
        System.out.printf("%.2f lv.", fuelPrice);
    }
}
