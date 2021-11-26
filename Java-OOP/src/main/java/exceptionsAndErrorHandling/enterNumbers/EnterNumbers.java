package exceptionsAndErrorHandling.enterNumbers;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(scan.nextLine());
                int end = Integer.parseInt(scan.nextLine());

                printNumbers(start, end);
            } catch (NumberFormatException e) {
                System.out.println("Enter valid Integers in the range [2...99]");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printNumbers(int start, int end) {
        try {
            validRange(start, end);
        } catch (InvalidRangeException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
        // Print array
        IntStream.range(start, end + 1).forEach(e -> System.out.print(e + " "));
        // New line
        System.out.println();
    }

    private static void validRange(int start, int end) throws InvalidRangeException {
        if (start <= 1 || end >= 100 || end <= start) {
            throw new InvalidRangeException("The range should be 1 < start < end < 100");
        }
    }
}
