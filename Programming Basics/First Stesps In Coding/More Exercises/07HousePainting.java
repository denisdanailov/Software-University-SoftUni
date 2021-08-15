package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double x = Double.parseDouble(scan.nextLine());
        Double y = Double.parseDouble(scan.nextLine());
        Double h = Double.parseDouble(scan.nextLine());

        //Решение зелена боя
        Double frontAndBackWall = x * x;
        Double sideWall = x * y;
        Double door = 1.2 * 2;
        Double windows = (1.5*1.5)*2;
        Double walls = ((frontAndBackWall*2) + (sideWall*2)) - door - windows;
        Double greenColor = walls/3.4;

        //Решение червена боя
        Double roofSide = x * y;
        Double roofFront = (x * h)/2;
        Double roof = (roofSide*2)+(roofFront*2);
        Double redColor = roof/4.3;

        //Принт
        System.out.printf("%.2f",greenColor);
        System.out.println();
        System.out.printf("%.2f",redColor);
    }
}
