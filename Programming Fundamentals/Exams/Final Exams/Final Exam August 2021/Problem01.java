package Exams.FinalExams.FinalExam;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];
            switch (action) {
                case "Change":
                    String character = tokens[1];
                    String replacement = tokens[2];
                    text = text.replace(character, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String substring = tokens[1];
                    if (includesSubstring(text, substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String otherString = tokens[1];
                    if (endsWithOtherString(text, otherString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String symbol = tokens[1];
                    if (text.indexOf(symbol) != -1) {
                        System.out.println(text.indexOf(symbol));
                    }
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String newString = "";
                    if (startIndex + length <= text.length()) {
                        newString = text.substring(startIndex, startIndex + length);
                    } else {
                        newString = text.substring(startIndex);
                    }
                    System.out.println(newString);
                    break;
            }
            input = scan.nextLine();
        }
    }

    public static boolean includesSubstring(String text, String substring) {
        if (text.indexOf(substring) != -1) {
            return true;
        }
        return false;
    }

    public static boolean endsWithOtherString(String text, String otherString) {
        String substring = text.substring(text.length() - otherString.length());
        if (otherString.equals(substring)) {
            return true;
        }
        return false;
    }
}
