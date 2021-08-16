package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputArr = scan.nextLine().split("");

        Map<String, Integer> charsMap = new LinkedHashMap<>();

        for (String symbol:
             inputArr) {

            if (charsMap.containsKey(symbol)) {
                int currentValue = charsMap.get(symbol);
                charsMap.replace(symbol, currentValue + 1);
            } else {

                if (!symbol.equals(" ")) {
                    charsMap.put(symbol, 1);
                }

            }
        }

        for (Map.Entry<String, Integer> dataSet : charsMap.entrySet()) {
            System.out.println(dataSet.getKey() + " -> " + dataSet.getValue());
        }

    }
}
