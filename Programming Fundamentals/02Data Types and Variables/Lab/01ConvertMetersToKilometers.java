package DataTypesAndVariables.Labs;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double meters = Double.parseDouble(scan.nextLine());

        System.out.printf("%.02f", meters / 1000);

    }
}
