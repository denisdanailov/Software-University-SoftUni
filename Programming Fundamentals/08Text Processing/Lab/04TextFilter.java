package TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] forbiddenWords = scan.nextLine().split(", ");

        String text = scan.nextLine();

        for (int i = 0; i < forbiddenWords.length; i++) {
            StringBuilder newWord = new StringBuilder();
            for (int j = 0; j < forbiddenWords[i].length(); j++) {
                newWord.append("*");
            }
           text = text.replace(forbiddenWords[i],newWord);
        }
        System.out.println(text);
    }
}
