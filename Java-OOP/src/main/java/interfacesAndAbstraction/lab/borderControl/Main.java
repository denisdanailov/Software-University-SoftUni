package interfacesAndAbstraction.lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> citizenAndRobotList = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(name, age, id);
                citizenAndRobotList.add(citizen);
            } else {
                String model = tokens[0];
                String id = tokens[1];
                Robot robot = new Robot(model, id);
                citizenAndRobotList.add(robot);
            }

            input = scan.nextLine();
        }

        String criteria = scan.nextLine();

        for (Identifiable object : citizenAndRobotList) {
            if (object.getId().endsWith(criteria)) {
                System.out.println(object.getId());
            }
        }

    }
}
