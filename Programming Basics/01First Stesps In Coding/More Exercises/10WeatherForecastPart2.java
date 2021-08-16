package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        double degrees = Double.parseDouble(scan.nextLine());
        //Проверки
        if (degrees >= 26.00 && degrees <=35.00){
            System.out.println("Hot");
        }else if (degrees >= 20.1 && degrees <= 25.9){
            System.out.println("Warm");
        }else if (degrees >= 15.00 && degrees <= 20.00){
            System.out.println("Mild");
        }else if (degrees >= 12.00 && degrees <= 14.9){
            System.out.println("Cool");
        }else if (degrees >= 5.00 && degrees <= 11.9){
            System.out.println("Cold");
        }else {
            System.out.println("unknown");
        }
    }
}
