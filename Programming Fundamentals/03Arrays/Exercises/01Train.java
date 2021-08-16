package Arrays.Exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;

        int[] peopleInt = new int[n];
        for (int i = 0; i < peopleInt.length; i++) {
            peopleInt[i] = scan.nextInt();
            sum += peopleInt[i];
        }

        String[] peopleString = new String[n];
        for (int i = 0; i < peopleString.length; i++) {
            peopleString[i] = String.valueOf(peopleInt[i]);
        }

        String output = String.join(" ",peopleString);

        System.out.println(output);
        System.out.println(sum);
    }
}
