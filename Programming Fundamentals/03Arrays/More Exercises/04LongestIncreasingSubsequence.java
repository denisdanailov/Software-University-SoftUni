package Arrays.MoreExercises;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = scan.nextLine().split(" ");

        int[] intArr = new int[strArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int i = 0; i < intArr.length - 1; i++) {
            if (intArr[i] < intArr[i + 1]) {

            }
        }
    }
}
