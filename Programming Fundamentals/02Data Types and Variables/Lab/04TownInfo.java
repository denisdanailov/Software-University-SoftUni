package DataTypesAndVariables.Labs;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String town = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        int sqrKM = Integer.parseInt(scan.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km", town, population, sqrKM);
    }
}
