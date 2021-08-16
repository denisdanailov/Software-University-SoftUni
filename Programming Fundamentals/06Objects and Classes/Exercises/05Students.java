package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    public static class Student {
        String firstName;
        String lastName;
        float grade;

        public Student (String fName, String sName, float grade) {
            this.firstName = fName;
            this.lastName = sName;
            this.grade = grade;
        }

        public String toString(){
            return String.format("%s %s: %.02f", firstName, lastName, grade);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(" ");

            Student student = new Student(tokens[0], tokens[1], Float.parseFloat(tokens[2]));

            list.add(student);
        }

        list.stream()
                .sorted((s1, s2)-> Float.compare(s2.grade,s1.grade))
                .forEach(student -> System.out.println(student.toString()));
    }
}
