package Exams.MidExam.ProgrammingFundamentalsMidExam05;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialHealth = 100;
        int initialBitcoins = 0;
        int bestRoom = 0;
        boolean slayed = false;

        String[] actions = scan.nextLine().split("\\|");

        for (int i = 0; i < actions.length; i++) {
            bestRoom += 1;
            String[] tokens = actions[i].split(" ");
            switch (tokens[0]) {
                case "potion":
                    int health = Integer.parseInt(tokens[1]);
                    if (health + initialHealth >= 100) {
                        System.out.printf("You healed for %d hp.%n", 100 - initialHealth);
                        initialHealth = 100;
                        System.out.println("Current health: 100 hp.");
                    } else {
                        System.out.printf("You healed for %d hp.%n", health);
                        initialHealth += health;
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    }
                    break;
                case "chest":
                    int bitcoins = Integer.parseInt(tokens[1]);
                    initialBitcoins += bitcoins;
                    System.out.printf("You found %d bitcoins.%n", bitcoins);
                    break;
                default:
                    String monster = tokens[0];
                    int damage = Integer.parseInt(tokens[1]);
                    if (initialHealth - damage > 0) {
                        initialHealth -= damage;
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        initialHealth = 0;
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", bestRoom);
                        slayed = true;
                        break;
                    }
                    break;
            }
            if (slayed) {
                break;
            }
        }

        if (!slayed) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", initialBitcoins);
            System.out.printf("Health: %d%n", initialHealth);
        }
    }
}
