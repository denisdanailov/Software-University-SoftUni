package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double celsius = Double.parseDouble(scan.nextLine());

        //Решение
        Double solution = (celsius*9/5)+32;

        //Принт
        System.out.printf("%.2f",solution);
    }
}
