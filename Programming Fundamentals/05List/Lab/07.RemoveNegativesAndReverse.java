package Lists.Labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] values = input.split( " ");

        List<Integer> numbers = new ArrayList<>();

        int counter = 0;

        for (int i = 0; i < values.length; i++) {
            int number = Integer.parseInt(values[i]);
            if (number >= 0 ) {
                counter++;
                numbers.add(number);
            }
        }

        Collections.reverse(numbers);

        if (counter == 0) {
            System.out.println("empty");
        } else {

            for (int number:
                    numbers) {
                System.out.print(number + " ");
            }

        }

    }
}
