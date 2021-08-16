package Arrays.Exercise;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int[] numArr = new int[input.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(input[i]);
        }

        int counter = 1;
        int repeatValue = 0;
        int oldCounter = 0;
        int oldRepeatValue = 0;
        for (int i = 0; i < numArr.length - 1; i++) {
            if (numArr[i] == numArr[i+1]) {
                counter += 1;
                repeatValue = numArr[i];
                if (counter > oldCounter) {
                    oldCounter = counter;
                    oldRepeatValue = repeatValue;
                }
            } else {
                counter = 1;
            }
        }

        for (int i = 0; i < oldCounter; i++) {
            System.out.print(oldRepeatValue + " ");
        }

    }
}
