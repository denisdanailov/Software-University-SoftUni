package Exams.FinalExams.ProgrammingFundamentalsFinalExam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        long coolThreshold = 1;

        List<String> emojiList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d");
        Matcher inputMatcher = pattern.matcher(input);

        while (inputMatcher.find()) {
            int digit = Integer.parseInt(inputMatcher.group());
            coolThreshold *= digit;
        }

//        for (int i = 0; i < input.length(); i++) {
//            // Проверка CoolThreshold
//            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
//                int digit = Character.getNumericValue(input.charAt(i));
//                coolThreshold *= digit;
//            }
//        }

        Pattern regex = Pattern.compile("(\\*{2}|:{2})[A-Z][a-z]{2,}\\1");
        Matcher text = regex.matcher(input);

        while (text.find()) {
            String emoji = text.group();
            emojiList.add(emoji);
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiList.size());

        for (String emoji :
                emojiList) {
            long sumCoolness = 0;
            for (int i = 2; i < emoji.length() - 2; i++) {
                sumCoolness += emoji.charAt(i);
            }
            if (sumCoolness >= coolThreshold) {
                System.out.println(emoji);
            }
        }
    }
}
