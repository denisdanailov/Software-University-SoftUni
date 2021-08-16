package Lists.Labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbersString = scan.nextLine();

        String[] values = numbersString.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            numbers.add(Integer.parseInt(values[i]));
        }

        String input = scan.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            switch (tokens[0]){
                case "Contains":
                    if (numbers.contains(Integer.parseInt(tokens[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (int number:
                                numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                    } else {
                        for (int number:
                                numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (tokens[1]) {
                        case "<":
                            for (int number:
                                    numbers) {
                                if (number < (Integer.parseInt(tokens[2]))) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println("");
                            break;
                        case ">":
                            for (int number:
                                    numbers) {
                                if (number > (Integer.parseInt(tokens[2]))) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println("");
                            break;
                        case ">=":
                            for (int number:
                                    numbers) {
                                if (number >= (Integer.parseInt(tokens[2]))) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println("");
                            break;
                        case "<=":
                            for (int number:
                                    numbers) {
                                if (number <= (Integer.parseInt(tokens[2]))) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println("");
                            break;
                    }
                    break;
            }

            input = scan.nextLine();
        }

    }
}
