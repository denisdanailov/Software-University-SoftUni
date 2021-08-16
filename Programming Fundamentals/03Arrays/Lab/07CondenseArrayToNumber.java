package Arrays.Labs;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = scan.nextLine().split(" ");

        int[] numArr = new int[strArr.length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        while (numArr.length > 1) {
            int[] condensedNumArr = new int[numArr.length - 1];
            for (int i = 0; i < numArr.length - 1; i++) {
                condensedNumArr[i] = numArr[i] + numArr[i+1];
            }
            numArr = condensedNumArr;
        }

        Arrays.stream(numArr).forEach(System.out::println);
    }
}
