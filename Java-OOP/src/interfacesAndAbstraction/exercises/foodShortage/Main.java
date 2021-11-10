package interfacesAndAbstraction.exercises.foodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Buyer> buyersMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];

                Buyer citizen = new Citizen(name, age, id, birthDate);
                buyersMap.put(name, citizen);
            } else {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];

                Buyer rebel = new Rebel(name, age, group);
                buyersMap.put(name, rebel);
            }
        }

        String foodBuyers = scan.nextLine();
        while (!foodBuyers.equals("End")) {
            if (buyersMap.containsKey(foodBuyers)) {
                buyersMap.get(foodBuyers).buyFood();
            }
            foodBuyers = scan.nextLine();
        }

        int sumTotalFood = buyersMap.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(sumTotalFood);
    }
}
