package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");

        int firstNumber = Integer.parseInt(tokens[0]);
        int secondNumber = Integer.parseInt(tokens[1]);
        String oddOrEven = scan.nextLine();

        Predicate<Integer> isEvenOrIsOdd = getEvenOrOddFilter(oddOrEven);

        IntStream.rangeClosed(firstNumber, secondNumber)
                .filter(isEvenOrIsOdd::test)
                .forEach(e -> System.out.print(e + " "));


    }

    private static Predicate<Integer> getEvenOrOddFilter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return e -> e % 2 != 0;
        }
        return e -> e % 2 == 0;
    }
}
