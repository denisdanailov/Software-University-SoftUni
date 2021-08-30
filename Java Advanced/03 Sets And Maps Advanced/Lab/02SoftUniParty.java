package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Set<String> regularGuestList = new TreeSet<>();
        Set<String> VIPGuestList = new TreeSet<>();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                VIPGuestList.add(input);
            } else {
                regularGuestList.add(input);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                VIPGuestList.remove(input);
            } else {
                regularGuestList.remove(input);
            }
            input = scan.nextLine();
        }

        System.out.println(VIPGuestList.size() + regularGuestList.size());

        printSet(VIPGuestList);
        printSet(regularGuestList);

    }

    public static void printSet(Set<String> set) {
        for (String guests : set) {
            System.out.println(guests);
        }
    }
}
