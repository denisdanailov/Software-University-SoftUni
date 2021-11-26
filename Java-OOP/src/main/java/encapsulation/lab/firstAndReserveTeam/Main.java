package encapsulation.lab.firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            try {
                Person person = new Person(firstName, lastName, age, salary);
                players.add(person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        Team team = new Team("Black Eagles");

        for (Person player : players) {
            team.addPlayer(player);
        }

        System.out.println("First team have" + " " + team.getFirstTeam().size() + " " + "players");
        System.out.println("Second team have" + " " + team.getReserveTeam().size() + " " + "players");
    }
}
