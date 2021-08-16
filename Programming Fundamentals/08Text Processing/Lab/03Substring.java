package TextProcessing.Lab;

import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String key = scan.nextLine();
        String text = scan.nextLine();

        int currIndex = text.indexOf(key);

        while (currIndex != -1) {
            text = text.replace(key,"");
            currIndex = text.indexOf(key);
        }

        System.out.println(text);
    }
}
