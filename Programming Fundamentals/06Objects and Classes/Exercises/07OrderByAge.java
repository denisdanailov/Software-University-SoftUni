package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static class Person{
    String name;
    String id;
    int age;

    public Person(String name, String id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, id, age);
    }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Person> list = new ArrayList<>();

        while (!input.equals("End")) {
           String[] tokens = input.split(" ");

           Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
           list.add(person);

            input = scan.nextLine();
        }

        list.stream()
                .sorted((p1,p2)-> Integer.compare(p1.age,p2.age))
                .forEach(person -> System.out.println(person.toString()));

    }
}
