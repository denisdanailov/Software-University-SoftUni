package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
    String firstName;
    String lastName;
    String age;
    String hometown;

    String getHometown() {
        return this.hometown;
    }
    String getFirstName() {
            return this.firstName;
    }
    String getLastName() {
        return this.lastName;
    }
    String getAge() {
            return this.age;
    }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Student> list = new ArrayList<>();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            Student pojo = new Student();

            pojo.firstName = tokens[0];
            pojo.lastName = tokens[1];
            pojo.age = tokens[2];
            pojo.hometown = tokens[3];

            list.add(pojo);

            input = scan.nextLine();
        }

        String hometown = scan.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (hometown.equals(list.get(i).getHometown())){
                System.out.printf("%s %s is %s years old%n",list.get(i).getFirstName(),list.get(i).getLastName(),list.get(i).getAge());
            }
        }

    }
}
