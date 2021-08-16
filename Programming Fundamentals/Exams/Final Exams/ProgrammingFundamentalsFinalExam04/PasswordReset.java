package Exams.FinalExams.ProgrammingFundamentalsFinalExam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        String input = scan.nextLine();

        StringBuilder newRawPass = new StringBuilder();
        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            switch (action) {
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            newRawPass.append(password.charAt(i));
                        }
                    }
                    password = newRawPass.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int beginningIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String oldSubstring = password.substring(beginningIndex, beginningIndex + length);
                    password = password.replaceFirst(oldSubstring,"");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.contains(substring)) {
                        while (password.contains(substring)) {
                            password = password.replace(substring, substitute);
                        }
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
