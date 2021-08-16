package TextProcessing.Lab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] strArr = input.split(" ");

        for (int i = 0; i < strArr.length; i++){
            for (int j = 0; j < strArr[i].length(); j++) {
                System.out.print(strArr[i]);
            }
        }
    }
}
