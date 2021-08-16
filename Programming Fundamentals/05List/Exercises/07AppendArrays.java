package Lists.Exercise;

import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] firstArr = input.split("\\|");

        String output = "";

        for (int i = firstArr.length - 1; i >= 0; i--) {

            String[] secondArr = firstArr[i].split("\\s+");

            for (int j = 0; j < secondArr.length; j++) {
                if (!secondArr[j].equals("")) {
                    output += secondArr[j].trim() + " ";
                }
            }
        }
        System.out.println(output);
    }
}
