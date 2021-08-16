package Exams.FinalExams.ProgrammingFundamentalsFinalExam05;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringBuilder activationKey = new StringBuilder();
        activationKey.append(input);

        input = scan.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String action = tokens[0];
            switch (action) {
                case"Contains":
                    String substring = tokens[1];
                    if (activationKey.indexOf(substring) >= 0) {
                        System.out.printf("%s contains %s%n", activationKey.toString(), substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case"Flip":
                    String caseType = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    switch (caseType) {
                        case"Upper":
                            String oldSubstring = activationKey.substring(startIndex, endIndex);
                            String newSubstring = oldSubstring.toUpperCase();
                            activationKey.replace(startIndex,endIndex, newSubstring);
                            System.out.println(activationKey.toString());
                            break;
                        case"Lower":
                            String currSubstring = activationKey.substring(startIndex, endIndex);
                            String updatedSubstring = currSubstring.toLowerCase();
                            activationKey.replace(startIndex,endIndex, updatedSubstring);
                            System.out.println(activationKey.toString());
                            break;
                    }
                    break;
                case"Slice":
                    int beginIndex = Integer.parseInt(tokens[1]);
                    int finalIndex = Integer.parseInt(tokens[2]);
                    activationKey.delete(beginIndex, finalIndex);
                    System.out.println(activationKey.toString());
                    break;
            }

            input = scan.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey.toString());
    }
}
