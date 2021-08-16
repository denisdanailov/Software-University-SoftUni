package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String stringValues = scan.nextLine();

        String[] intValues = stringValues.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < intValues.length; i++) {
           int number = Integer.parseInt(intValues[i]);
           numbers.add(number);
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    if (Integer.parseInt(tokens[2]) >= numbers.size() || Integer.parseInt(tokens[2]) < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    }
                    break;
                case "Remove":
                    if (Integer.parseInt(tokens[1]) >= numbers.size() || Integer.parseInt(tokens[1]) < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(Integer.parseInt(tokens[1]));
                    }
                    break;
                case "Shift":
                    switch (tokens[1]) {
                        case "left":
                            for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                                int lastValue = numbers.get(0);
                                numbers.remove(0);
                                numbers.add(lastValue);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                                int firstNumber = numbers.get(numbers.size()-1);
                                numbers.remove(numbers.size()-1);
                                numbers.add(0,firstNumber);
                            }
                            break;
                    }
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
