package Arrays.Labs;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        String[] stringArray1 = input1.split(" ");
        String[] stringArray2 = input2.split(" ");

        int[] firstNumbers = new int[stringArray1.length];
        for (int i = 0; i < firstNumbers.length; i++) {
            firstNumbers[i] = Integer.parseInt(stringArray1[i]);
        }

        int[] secondNumbers = new int[stringArray2.length];
        for (int i = 0; i < secondNumbers.length; i++) {
            secondNumbers[i] = Integer.parseInt(stringArray2[i]);
        }

        int sum = 0;
        boolean flag = true;

        for (int i = 0; i < firstNumbers.length; i++) {
            if (firstNumbers[i] == secondNumbers[i]) {
                sum += firstNumbers[i];
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
