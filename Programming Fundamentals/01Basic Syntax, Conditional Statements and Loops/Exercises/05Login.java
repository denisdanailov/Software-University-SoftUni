package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();
        String password = scan.nextLine();

        String validPAss = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            validPAss += username.charAt(i);
        }

        int loginCount = 0;
        String output = "";
        boolean flag = false;

        while (!validPAss.equals(password)) {
            loginCount++;
            if (loginCount == 4){
                flag = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            password = scan.nextLine();
        }

        if (flag){
            System.out.printf("User %s blocked!", username);
        } else {
            System.out.printf("User %s logged in.", username);
        }

    }
}
