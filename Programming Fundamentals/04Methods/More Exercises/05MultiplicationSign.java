package Methods.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] intArr = new int[]{scan.nextInt(), scan.nextInt(), scan.nextInt()};

        printPositiveNegativeOrZero(intArr);
    }

    public static void printPositiveNegativeOrZero(int[] arr) {
        int countNegative = 0;
        int countZero = 0;

        for (int number :
                arr) {
            if (number < 0) {
                countNegative += 1;
            } else if (number == 0) {
                countZero += 1;
            }
        }

        if (countZero > 0) {
            System.out.println("zero");
        } else if (countNegative % 2 != 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}
