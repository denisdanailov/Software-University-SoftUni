package FirstStepsInCoding.Labs;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int project = Integer.parseInt(scan.nextLine());

        int result = project * 3;

        System.out.println("The architect " + name + " will need " + result + " hours to complete " + project + " project/s.");
    }
}
