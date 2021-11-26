package workingWithAbstraction.lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] tokens = scan.nextLine().split("\\s+");
        while (!tokens[0].equals("Exit")) {
            studentSystem.ParseCommand(tokens);
            tokens = scan.nextLine().split("\\s+");
        }
    }
}
