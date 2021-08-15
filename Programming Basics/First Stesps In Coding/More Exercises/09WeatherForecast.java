package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        String text = scan.nextLine();

        //Проверка
        if (text.equals("sunny")){
            System.out.println("It's warm outside!");
        }else {
            System.out.println("It's cold outside!");
        }
    }
}
