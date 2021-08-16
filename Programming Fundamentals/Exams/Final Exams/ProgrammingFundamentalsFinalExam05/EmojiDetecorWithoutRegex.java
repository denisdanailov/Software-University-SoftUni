package Exams.FinalExams.ProgrammingFundamentalsFinalExam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmojiDetecorWithoutRegex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        long coolThreshold = 1;
        int border1 = 0;
        int border2 = 0;
        List<String> emojiList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            // Проверка CoolThreshold
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                int digit = Character.getNumericValue(input.charAt(i));
                coolThreshold *= digit;
            }
            // Проверка Emoji
            if (input.charAt(i) == ':' | input.charAt(i) == '*') {
                if (input.charAt(i) == ':') {
                    border1 += 1;
                } else {
                    border2 += 1;
                }
            }
            if (border1 >= 2 | border2 >= 2) {
                if (border1 >= 2) {
                    border1 = 0;
                    String emoji = returnEmoji(input, i, ':');
                    if (isEmoji(emoji)) {
                        if (isValidEmoji(emoji)) {
                            if (isBordered(input, emoji)) {
                                i = i + emoji.length() + 2;
                                int index = input.indexOf(emoji);
                                char symbol = input.charAt(index - 1);
                                emoji = String.format("%c%c%s%c%c", symbol, symbol, emoji, symbol, symbol);
                                emojiList.add(emoji);
                            }
                        }
                    }
                } else {
                    border2 = 0;
                    String emoji = returnEmoji(input, i, '*');
                    if (isEmoji(emoji)) {
                        if (isValidEmoji(emoji)) {
                            if (isBordered(input, emoji)) {
                                i = i + emoji.length() + 2;
                                int index = input.indexOf(emoji);
                                char symbol = input.charAt(index - 1);
                                emoji = String.format("%c%c%s%c%c", symbol, symbol, emoji, symbol, symbol);
                                emojiList.add(emoji);
                            }
                        }
                    }
                }
            }
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

    public static boolean isBordered(String input, String emoji) {
        boolean isBordered = false;
        int index = input.indexOf(emoji);
        if ((input.charAt(index - 1) == ':' && input.charAt(index - 2) == ':') | (input.charAt(index - 1) == '*' && input.charAt(index - 2) == '*')) {
            if ((input.charAt(index + emoji.length()) == ':' && input.charAt(index + emoji.length() + 1) == ':') | (input.charAt(index + emoji.length()) == '*' && input.charAt(index + emoji.length() + 1) == '*')) {
                isBordered = true;
            }
        }
        return isBordered;
    }

    public static boolean isValidEmoji(String emoji) {
        boolean isValid = false;
        if (emoji.length() >= 3) {
            if (Character.isUpperCase(emoji.charAt(0))) {
                boolean allLowerCase = true;
                boolean isDigit = false;
                for (int i = 1; i < emoji.length(); i++) {
                    if (Character.isUpperCase(emoji.charAt(i))) {
                        allLowerCase = false;
                    }
                    if (Character.isDigit(emoji.charAt(i))) {
                        isDigit = true;
                    }
                }
                if (allLowerCase && !isDigit) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    public static boolean isEmoji(String emoji) {
        boolean isEmoji = true;
        for (int i = 0; i < emoji.length(); i++) {
            if (emoji.charAt(i) == ' ' | emoji.charAt(i) == ',') {
                isEmoji = false;
                break;
            }
        }
        return isEmoji;
    }

    public static String returnEmoji(String input, int index, char symbol) {
        StringBuilder emoji = new StringBuilder();
        if (index + 1 < input.length()) {
            int count = 0;
            for (int j = index + 1; j < input.length(); j++) {
                if (input.charAt(j) == symbol) {
                    count += 1;
                }
                if (count < 2 && input.charAt(j) != symbol) {
                    emoji.append(input.charAt(j));
                }
                if (count == 2) {
                    break;
                }
            }
        }
        return emoji.toString();
    }
}
