package MockExamsPB.March2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minutes = Integer.parseInt(scan.nextLine());
        int walks = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());

        double caloriesBurnt = (minutes * 5) * walks;

        if (caloriesBurnt >= (calories / 2)) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", caloriesBurnt);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", caloriesBurnt);
        }
    }
}
