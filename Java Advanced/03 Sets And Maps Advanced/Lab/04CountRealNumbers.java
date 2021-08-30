package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numCount = new LinkedHashMap<>();

        Arrays.stream(input).forEach(num -> {
            if (numCount.containsKey(num)) {
                int currValue = numCount.get(num);
                numCount.put(num, currValue + 1);
            } else {
                numCount.put(num, 1);
            }
        });

        for (Map.Entry<Double, Integer> entry : numCount.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }
    }
}
