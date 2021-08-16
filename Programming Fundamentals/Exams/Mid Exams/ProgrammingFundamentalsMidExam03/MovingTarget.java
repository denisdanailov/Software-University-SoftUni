package Exams.MidExam.ProgrammingFundamentalsMidExam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        List<Integer> targets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            targets.add(Integer.parseInt(arr[i]));
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Shoot":
                    int index = Integer.parseInt(tokens[1]);
                    int power = Integer.parseInt(tokens[2]);
                    if (index < targets.size()) {
                        int newValue = targets.get(index) - power;
                        targets.set(index, newValue);
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int index1 = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);
                    if (index1 < targets.size()) {
                        targets.set(index1, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int index2 = Integer.parseInt(tokens[1]);
                    int radius = Integer.parseInt(tokens[2]);
                    if (index2 <targets.size()) {
                        if ((index2 + radius) < targets.size() && (index2 - radius) >= 0) {
                            for (int i = index2 + radius; i >= index2 - radius; i--) {
                                targets.remove(i);
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if (i != targets.size() - 1) {
                System.out.print(targets.get(i) + "|");
            } else {
                System.out.print(targets.get(i));
                System.out.println();
            }
        }
    }
}
