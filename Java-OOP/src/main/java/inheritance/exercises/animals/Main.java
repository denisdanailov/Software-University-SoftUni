package inheritance.exercises.animals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animalType = scan.nextLine();
        while (!animalType.equals("Beast!")) {
            String[] animalInfo = scan.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = "";

            switch (animalType) {
                case "Dog":
                    gender = animalInfo[2];
                    try {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog.toString());
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Frog":
                    gender = animalInfo[2];
                    try {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog.toString());
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Cat":
                    gender = animalInfo[2];
                    try {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat.toString());
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Kitten":
                    try {
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten.toString());
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Tomcat":
                    try {
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat.toString());
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
            }

            animalType = scan.nextLine();
        }
    }
}
