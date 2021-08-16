package Lists.Labs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] values = input.split(" ");

        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            double number = Double.parseDouble(values[i]);
            numbers.add(number);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            int indexValue = i;
            double currentValue = numbers.get(i);
            double nextValue = numbers.get(i+1);

            if (currentValue == nextValue) {
                numbers.remove(i+1);
                numbers.set(i,nextValue+currentValue);
                i = -1;
            } else {
                i = indexValue;
            }
        }

        String output = joinNumbersByDelimiter(numbers, " ");
        System.out.println(output);
    }

    public static  String joinNumbersByDelimiter(List<Double> numbers, String delimiter) {
        String output = "";
        for (Double number:
             numbers) {
            output += (new DecimalFormat("0.#").format(number) + delimiter);
        }
        return output;
    }
}
