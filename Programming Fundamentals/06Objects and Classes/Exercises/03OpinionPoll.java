package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return this.name + " - " + this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String input = scan.nextLine();
            String[] tokens = input.split(" ");

            Person newPerson = new Person(tokens[0], Integer.parseInt(tokens[1]));

            list.add(newPerson);
        }

        list.stream()
                .filter(newPerson -> newPerson.age > 30)
                .sorted((p1,p2) -> p1.name.compareTo(p2.name))
                .forEach(newPerson -> System.out.println(newPerson.toString()));

    }
}
