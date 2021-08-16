package Exams.MidExam.ProgrammingFundamentalsMidExamRetakeAug19;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] warShip = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int healthCapacity = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();
        int damage = 0;
        int index = 0;
        boolean youWin = false;
        boolean youLose = false;

        while (!input.equals("Retire")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            switch (action) {
                case "Fire":
                    index = Integer.parseInt(tokens[1]);
                    damage = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < warShip.length) {
                        warShip[index] -= damage;
                        if (warShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            youWin = true;
                        }
                    }
                        break;
                case "Defend":
                    int startSection = Integer.parseInt(tokens[1]);
                    int endSection = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if (indexesAreValid(startSection, endSection, pirateShip)) {
                        for (int i = startSection; i <= endSection; i++) {
                            pirateShip[i] -= damage;
                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                youLose = true;
                                break;
                            }
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < pirateShip.length) {
                        if (pirateShip[index] + health > healthCapacity) {
                            pirateShip[index] = healthCapacity;
                        } else {
                            pirateShip[index] += health;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    double percentHP = healthCapacity * 0.20;
                    for (int section:
                         pirateShip) {
                        if (section < percentHP) {
                            count += 1;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            if (youWin) {
                break;
            }
            if (youLose) {
                break;
            }
            input = scan.nextLine();
        }

        if (!youWin && !youLose) {
            int pirateShipStatus = 0;
            for (int section:
                 pirateShip) {
                pirateShipStatus += section;
            }
            System.out.printf("Pirate ship status: %d%n", pirateShipStatus);
            int warShipStatus = 0;
            for (int section:
                    warShip) {
                warShipStatus += section;
            }
            System.out.printf("Warship status: %d%n", warShipStatus);
        }
    }

    public static boolean indexesAreValid (int index1, int index2, int[] arr) {
        if (index1 >= 0 && index2 >= 0 && index1 < arr.length && index2 < arr.length) {
            return true;
        } else {
            return false;
        }
    }
}
