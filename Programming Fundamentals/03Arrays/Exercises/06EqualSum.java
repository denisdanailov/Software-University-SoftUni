package Arrays.Exercise;

import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        boolean flag = true;
        for (int i = 0; i < numbers.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                sum1 += numbers[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                sum2 += numbers[j];
            }
            if (sum1 == sum2) {
                System.out.println(i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("no");
        }
    }
}
