package ObjectsAndClasses.Lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] words = input.split(" ");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int x = rnd.nextInt(words.length);
            int y = rnd.nextInt(words.length);
            String currentWord = words[x];
            words[x] = words[y];
            words[y] = currentWord;
        }

        for (String word :
                words) {
            System.out.println(word);
        }
    }
}
