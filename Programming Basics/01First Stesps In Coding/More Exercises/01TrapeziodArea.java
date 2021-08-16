package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TrapeziodArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Вход
        Double b1 = Double.parseDouble(scan.nextLine());
        Double b2 = Double.parseDouble(scan.nextLine());
        Double h = Double.parseDouble(scan.nextLine());

        // Решение
        Double solution = ((b1+b2)*h)/2.0;

        // Принтиране
        System.out.printf("%.2f",solution);
    }
}
