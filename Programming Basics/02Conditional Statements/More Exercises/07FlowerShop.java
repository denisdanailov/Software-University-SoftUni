package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int flower1 = Integer.parseInt(scan.nextLine());
        int flower2 = Integer.parseInt(scan.nextLine());
        int roses = Integer.parseInt(scan.nextLine());
        int cactus = Integer.parseInt(scan.nextLine());
        double pricePresent = Double.parseDouble(scan.nextLine());
        //Решение
        double revenueFlowers = (flower1*3.25)+(flower2*4)+(roses*3.50)+(cactus*8);
        double profitFlowers = revenueFlowers * 0.95;
        //Проверки
        if (profitFlowers >= pricePresent) {
            double moneyLeft = profitFlowers - pricePresent;
            System.out.printf("She is left with %.0f leva.", Math.floor(moneyLeft));
        } else {
            double moneyNeeded = pricePresent - profitFlowers;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(moneyNeeded));
        }
    }
}
