package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double a = Double.parseDouble(scan.nextLine());
        Double h = Double.parseDouble(scan.nextLine());

        //Решението
        Double solution = (a*h)/2;

        //Принтиране
        System.out.printf("%.2f",solution);
    }
}
