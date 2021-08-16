package ConditionalStatements.Exercises;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        double bonus = 0;

        if (num <= 100){
            bonus = 5;
        } else if (num > 1000){
            bonus = num * 0.10;
        } else if (num > 100){
            bonus = num * 0.20;
        }

        if (num % 2 == 0){
            bonus = bonus +1;
        } else if (num % 10 == 5){
            bonus = bonus + 2;
        }
        System.out.print(bonus);
        System.out.println();
        System.out.print(bonus+num);
    }
}
