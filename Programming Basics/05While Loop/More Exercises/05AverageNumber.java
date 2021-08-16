package WhileLoop.MoreExercises;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            sum += num;
        }
        double avgNum = sum / n;

        System.out.printf("%.2f", avgNum);
    }
}
