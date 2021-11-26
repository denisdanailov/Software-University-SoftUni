package interfacesAndAbstraction.exercises.birthdayCelebration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthAbleList = new ArrayList<>();

        String nextLine = reader.readLine();
        while (!nextLine.equals("End")) {
            String[] tokens = nextLine.split("\\s+");
            String classType = tokens[0];
            switch(classType) {
                case "Citizen": {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];

                    Birthable citizen = new Citizen(name, age, id, birthDate);
                    birthAbleList.add(citizen);
                }
                    break;
                case "Robot": {
                    String id = tokens[1];
                    String model = tokens[2];

                    Identifiable robot = new Robot(id, model);
                }
                    break;
                case "Pet": {
                    String name = tokens[1];
                    String birthDate = tokens[2];

                    Birthable pet = new Pet(name, birthDate);
                    birthAbleList.add(pet);
                }
                    break;
            }
            nextLine = reader.readLine();
        }

        String birthYear = reader.readLine();

        birthAbleList.stream()
                .filter(e -> e.getBirthDate().endsWith(birthYear))
                .forEach(e -> System.out.println(e.getBirthDate()));
    }
}
