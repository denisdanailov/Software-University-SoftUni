package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double priceSkumriq = Double.parseDouble(scan.nextLine());
        Double priceCaca = Double.parseDouble(scan.nextLine());
        Double kgPalamud = Double.parseDouble(scan.nextLine());
        Double kgSafrid = Double.parseDouble(scan.nextLine());
        Double kgMussles = Double.parseDouble(scan.nextLine());

        //Решения
        Double pricePalamud = priceSkumriq + priceSkumriq*0.6;
        Double priceSafrid = priceCaca + priceCaca*0.8;
        Double priceMussles = 7.50;

        Double total = (kgPalamud*pricePalamud) + (kgSafrid*priceSafrid) + (kgMussles*priceMussles);

        //Принт
        System.out.printf("%.2f",total);
    }
}
