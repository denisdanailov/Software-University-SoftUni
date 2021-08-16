package Exams.FinalExams.ProgrammingFundamentalsFinalExam01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String action = tokens[0];
            switch (action) {
                case "Move":
                    int numLetters = Integer.parseInt(tokens[1]);
                    //Проверка за празен стринг
                    if (message.length() > 0 && numLetters < message.length()) {
                        StringBuilder strBuild = new StringBuilder(message);
                        for (int i = 0; i < numLetters; i++) {
                            strBuild.append(strBuild.charAt(0));
                            strBuild.deleteCharAt(0);
                        }
                        message = strBuild.toString();
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String element = tokens[2];
                    //Проверка за елемент
                    if (index >= 0 && index <= message.length()) {
                        StringBuilder stringBuilder = new StringBuilder(message);
                        stringBuilder.insert(index, element);
                        message = stringBuilder.toString();
                    }
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if (message.contains(substring)) {
                        message = message.replace(substring, replacement);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", message);
    }
}
