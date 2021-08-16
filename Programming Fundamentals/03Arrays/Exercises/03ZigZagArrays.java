package Arrays.Exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] first = new int[n];
        int[] second = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            count++;
            String[] input = scan.nextLine().split(" ");
            if (count == 1) {
                first[i] = Integer.parseInt(input[0]);
                second[i] = Integer.parseInt(input[1]);
            } else {
                count = 0;
                first[i] = Integer.parseInt(input[1]);
                second[i] = Integer.parseInt(input[0]);
            }
        }

        for (int number : first) {
            System.out.print(number + " ");
        }
        System.out.println("");
        for (int number : second) {
            System.out.print(number + " ");
        }
    }
}
