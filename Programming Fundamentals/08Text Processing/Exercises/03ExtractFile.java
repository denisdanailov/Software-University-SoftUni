package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int currIndex = 0;
        int nextKeyIndex = input.indexOf("\\", currIndex);

        while (nextKeyIndex != -1) {
            currIndex = nextKeyIndex + 1;
           nextKeyIndex = input.indexOf("\\", currIndex);
        }

        String substring = input.substring(currIndex);

        int newNextKeyIndex = substring.indexOf(".", 0);
        int newCurrIndex = newNextKeyIndex + 1;

        String fileName = substring.substring(0,newNextKeyIndex);
        String extension = substring.substring(newCurrIndex);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
