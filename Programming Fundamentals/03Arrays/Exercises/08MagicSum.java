package Arrays.Exercise;

import java.util.Scanner;

public class MagicSum {

    public static int[] toIntArr(String[] strArr){

        int[] intArr = new int[strArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        return intArr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = scan.nextLine().split(" ");
        int compareNum = Integer.parseInt(scan.nextLine());

        int[] numArr = toIntArr(strArr);

        for (int i = 0; i < numArr.length; i++) {
            for (int j = i+1; j < numArr.length; j++) {
                if (numArr[i] + numArr[j] == compareNum) {
                    System.out.println(numArr[i] + " " + numArr[j]);
                }
            }
        }
    }
}
