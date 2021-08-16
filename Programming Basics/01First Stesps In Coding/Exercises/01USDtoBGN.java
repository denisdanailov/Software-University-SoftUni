package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double usd = Double.parseDouble(scan.nextLine());

        Double bgn = usd * 1.79549;

        System.out.println(bgn);
    }
}
