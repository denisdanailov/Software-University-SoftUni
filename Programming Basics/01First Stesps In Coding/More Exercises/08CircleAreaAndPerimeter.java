package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double r = Double.parseDouble(scan.nextLine());

        //Решение
        Double circleArea = Math.PI*r*r;
        Double circleParameter = 2 * Math.PI * r;

        //Изход
        System.out.printf("%.2f",circleArea);
        System.out.println();
        System.out.printf("%.2f",circleParameter);
    }
}
