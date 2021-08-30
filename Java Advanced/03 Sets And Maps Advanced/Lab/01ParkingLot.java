package SetsAndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Set<String> carParking = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] tokens = input.split(",\\s+");
            String action = tokens[0];
            String carRegNumber = tokens[1];
            switch (action) {
                case "IN":
                    carParking.add(carRegNumber);
                    break;
                case "OUT":
                    carParking.remove(carRegNumber);
                    break;
            }
            input = scan.nextLine();
        }

        if (carParking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : carParking) {
                System.out.println(car);
            }
        }
    }
}
