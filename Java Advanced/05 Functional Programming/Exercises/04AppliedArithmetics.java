package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArray = readInput(scan, "\\s+");
        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    // Create function add 1
                    Function<int[], int[]> add1 = numbers -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] += 1;
                        }
                        return numbers;
                    };
                    // Apply function
                    inputArray = add1.apply(inputArray);
                    break;
                case "multiply":
                    // Create function multiply by 2
                    Function<int[], int[]> multiplyBy2 = numbers -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] *= 2;
                        }
                        return numbers;
                    };
                    // Apply function
                    inputArray = multiplyBy2.apply(inputArray);
                    break;
                case "subtract":
                    // Create function subtract 1
                    Function<int[], int[]> subtract1 = numbers -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] -= 1;
                        }
                        return numbers;
                    };
                    // Apply function
                    inputArray = subtract1.apply(inputArray);
                    break;
                case "print":
                    // Create function print all array elements
                    Consumer<int[]> printNumbers = numbers -> {
                        for (int number :
                                numbers) {
                            System.out.print(number + " ");
                        }
                    };
                    // Apply function
                    printNumbers.accept(inputArray);
                    System.out.println();
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static int[] readInput(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
