package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double maxVolume = 0;
        String output = "";

        for (int i = 0; i < n; i++) {
            double volume = 0;
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            volume = Math.PI * Math.pow(radius, 2) * height;
            if (maxVolume < volume){
                maxVolume = volume;
                output = model;
            }
        }
        System.out.println(output);
    }
}
