package Exams.MidExam.ProgrammingFundamentalsMidExam05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List <String> inventory = new ArrayList<>(Arrays.asList(scan.nextLine().split(", ")));

        String input = scan.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Collect":
                    if (!inventory.contains(tokens[2])) {
                        inventory.add(tokens[2]);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(tokens[2])) {
                        inventory.remove(tokens[2]);
                    }
                    break;
                case "Combine":
                    String[] items = tokens[3].split(":");
                    if (inventory.contains(items[0])) {
                        inventory.add(inventory.indexOf(items[0]) + 1, items[1]);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(tokens[2])) {
                        inventory.remove(tokens[2]);
                        inventory.add(tokens[2]);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < inventory.size(); i++) {
            if (i != inventory.size() - 1) {
                System.out.print(inventory.get(i) + ", ");
            } else {
                System.out.print(inventory.get(i));
            }
        }
    }
}
