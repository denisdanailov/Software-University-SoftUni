package Arrays.Exercise;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            flag = false;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.print(numbers[numbers.length-1]+ " ");
    }
}
