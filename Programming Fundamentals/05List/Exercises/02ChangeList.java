package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbersString = scan.nextLine();

        String[] values = numbersString.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            int number = Integer.parseInt(values[i]);
            numbers.add(number);
        }

        String input = scan.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Delete":
                    while (numbers.contains(Integer.parseInt(tokens[1]))) {
                        numbers.remove((Integer)Integer.parseInt(tokens[1]));
                    }
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    break;
            }

            input = scan.nextLine();
        }

        for (int number:
             numbers) {
            System.out.print(number + " ");
        }
    }
}
