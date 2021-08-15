package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class PrintfMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        Double gpa = Double.parseDouble(scan.nextLine());

        //%s = String; %d = Integer; %f = Double
        System.out.printf("My name is %s %s, my age is %d, and my GPA is %.2f",firstName,lastName,age,gpa);

    }
}
