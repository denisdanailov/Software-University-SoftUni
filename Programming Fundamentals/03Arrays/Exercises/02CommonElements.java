package Arrays.Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        String[] firstArray = input1.split(" ");

        String[] secondArray = input2.split(" ");

        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i].equals(secondArray[j])) {
                    System.out.print(secondArray[j] + " ");
                }
            }
        }
    }
}
