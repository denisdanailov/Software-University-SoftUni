package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double people = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());

        int courses = (int)Math.ceil(people/ capacity);

        System.out.println(courses);
    }
}
