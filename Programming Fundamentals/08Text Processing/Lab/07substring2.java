package TextProcessing.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class substring2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String key = scan.nextLine();
        String text = scan.nextLine();

        int currIndex = 0;
        int nextKeyIndex = text.indexOf(key, currIndex);

        List<String> substringList = new ArrayList<>();

        while (nextKeyIndex != -1) {
            currIndex = 0;
            while (nextKeyIndex != -1) {
                String substring = text.substring(currIndex, nextKeyIndex);
                substringList.add(substring);
                currIndex = nextKeyIndex + key.length();
                nextKeyIndex = text.indexOf(key, currIndex);
            }
            String finalSubstring = text.substring(currIndex);
            substringList.add(finalSubstring);
            text = String.join("", substringList);
            nextKeyIndex = text.indexOf(key, 0);
            if (nextKeyIndex != -1) {
              substringList.clear();
            }
        }
        System.out.println(text);
    }
}
