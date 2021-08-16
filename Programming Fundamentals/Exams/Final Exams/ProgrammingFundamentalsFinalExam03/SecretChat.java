package Exams.FinalExams.ProgrammingFundamentalsFinalExam03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String action = tokens[0];
            switch (action) {
                case"InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    StringBuilder strBuilder = new StringBuilder(message);
                    strBuilder.insert(index, " ");
                    message = strBuilder.toString();
                    System.out.println(message);
                    break;
                case"Reverse":
                    String substring = tokens[1];
                    if (message.contains(substring)) {
                        StringBuilder strBuild = new StringBuilder(message);
                        strBuild.delete(message.indexOf(substring),message.indexOf(substring) + substring.length());
                        substring = reverseSubstring(substring);
                        strBuild.append(substring);
                        message = strBuild.toString();
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case"ChangeAll":
                    String substring2 = tokens[1];
                    String replacement = tokens[2];
                    if (message.contains(substring2)) {
                        message = message.replace(substring2, replacement);
                        System.out.println(message);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", message);
    }

    public static String reverseSubstring (String substring) {
        StringBuilder strBuild = new StringBuilder();
        for (int i = substring.length() - 1; i >= 0 ; i--) {
           strBuild.append(substring.charAt(i));
        }
        substring = strBuild.toString();
        return substring;
    }
}
