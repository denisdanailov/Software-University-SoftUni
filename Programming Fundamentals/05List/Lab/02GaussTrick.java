package Lists.Labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] stringValues = input.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < stringValues.length; i++) {
            int number = Integer.parseInt(stringValues[i]);
            numbers.add(number);
        }

        List<Integer> newList = new ArrayList<>();

        if (numbers.size() % 2 == 0) {

            for (int i = 0; i < numbers.size() / 2; i++) {
                int firstValue = numbers.get(i);
                int secondValue = numbers.get(numbers.size() - (1 + i));

                newList.add(firstValue + secondValue);
            }

        } else {

            for (int i = 0; i <= numbers.size() / 2; i++) {
                int firstValue = numbers.get(i);
                int secondValue = numbers.get(numbers.size() - (1 + i));

                if (numbers.size() / 2 == numbers.size() - (1 + i)) {
                    newList.add(firstValue);
                } else {
                    newList.add(firstValue + secondValue);
                }
            }

        }

        for (int number :
                newList) {
            System.out.print(number + " ");
        }
    }
}
