package AssociativeArrays.Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] values = input.split(" ");

        double[] numbers = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble((values[i]));
        }

        Map<Double, Integer> countNumbers = new TreeMap<>();

        for (int i = 0; i < numbers.length; i++) {
            Integer currentCount = countNumbers.get(numbers[i]);
            if (currentCount == null) {
                currentCount = 0;
            }
            countNumbers.put(numbers[i],currentCount + 1);
        }

        for (Map.Entry<Double, Integer> dataSet : countNumbers.entrySet()) {
           System.out.printf("%.0f -> %d%n",dataSet.getKey(),dataSet.getValue());
        }

    }
}
