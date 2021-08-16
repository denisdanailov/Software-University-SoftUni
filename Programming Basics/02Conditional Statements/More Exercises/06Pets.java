package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int days = Integer.parseInt(scan.nextLine());
        int foodLeft = Integer.parseInt(scan.nextLine());
        double foodPerDayDog = Double.parseDouble(scan.nextLine());
        double foodPerDayCat = Double.parseDouble(scan.nextLine());
        double foodPerDayTurtle = Double.parseDouble(scan.nextLine());
        //Решение
        double foodDog = foodPerDayDog * days;
        double foodCat = foodPerDayCat * days;
        double foodTurtle = (foodPerDayTurtle * days) / 1000;
        double totalFood = foodDog + foodCat + foodTurtle;
        //Проверка
        if (totalFood <= foodLeft) {
            double foodSurplus = foodLeft - totalFood;
            System.out.printf("%.0f kilos of food left.", Math.floor(foodSurplus));
        } else {
            double foodShortage = totalFood - foodLeft;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodShortage));
        }
    }
}
