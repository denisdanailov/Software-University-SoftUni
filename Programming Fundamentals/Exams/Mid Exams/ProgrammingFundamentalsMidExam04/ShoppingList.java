package Exams.MidExam.ProgrammingFundamentalsMidExam04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>(Arrays.asList(scan.nextLine().split("!")));

        String input = scan.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            String item = tokens[1];
            switch (action) {
                case "Urgent":
                    if (!list.contains(item)) {
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(item)) {
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    if (list.contains(item)) {
                        int oldItem = list.indexOf(item);
                        String newItem = tokens[2];
                        list.set(oldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)) {
                        list.remove(item);
                        list.add(item);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() -1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
                System.out.println();
            }
        }
    }
}
