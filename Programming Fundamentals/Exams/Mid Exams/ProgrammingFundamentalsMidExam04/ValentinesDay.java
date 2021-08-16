package Exams.MidExam.ProgrammingFundamentalsMidExam04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ValentinesDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>(Arrays.asList(scan.nextLine().split("@")));

        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            houses.add(Integer.parseInt(list.get(i)));
        }

        String input = scan.nextLine();

        int initialIndex = 0;
        int cupidIndex = 0;
        while (!input.equals("Love!")) {
            String[] tokens = input.split(" ");
            int jumps = Integer.parseInt(tokens[1]);
            cupidIndex = initialIndex + jumps;
            if (houses.size() <= cupidIndex) {
                int targetHouse = houses.get(0);
                int oldValue = houses.get(0);
                if (oldValue == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", 0);
                    input = scan.nextLine();
                    continue;
                }
                int newValue = targetHouse - 2;
                houses.set(0,newValue);
                if (newValue == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", 0);
                }
                initialIndex = 0;
            } else {
                int targetHouse = houses.get(cupidIndex);
                int oldValue = houses.get(cupidIndex);
                if (oldValue == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", cupidIndex);
                    continue;
                }
                int newValue = targetHouse - 2;
                houses.set(cupidIndex,newValue);
                if (newValue == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", cupidIndex);
                }
                initialIndex = cupidIndex;
            }
            input = scan.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n",cupidIndex);
        int countValentine = 0;
        for (int house:
             houses) {
            if (house == 0) {
                countValentine += 1;
            }
        }
        if (countValentine == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", houses.size() - countValentine);
        }
    }
}
