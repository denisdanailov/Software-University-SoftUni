package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read names
        String[] names = scan.nextLine().split("\\s+");
        // Create special function: Consumer -> returns void
        Consumer<String> printName = name -> System.out.println(name);
        // Print with forEach
        for (String name : names) {
            printName.accept(name);
        }
        // Print with StreamAPI
        // Arrays.stream(names).forEach(name -> printName.accept(name));
    }
}
