package AssociativeArrays.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();

        String[] arrStrings = inputLine.toLowerCase().split(" ");

        Map<String, Integer> numOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < arrStrings.length; i++) {
        Integer count = numOccurrences.get(arrStrings[i]);
        if (count == null) {
            count = 1;
            numOccurrences.put(arrStrings[i], count);
        } else {
            count += 1 ;
            numOccurrences.put(arrStrings[i], count);
        }
        }

        int countOdd = 0;
        for (Map.Entry<String, Integer> dataSet : numOccurrences.entrySet()) {
            if (dataSet.getValue() % 2 != 0) {
                countOdd++;
            }
        }

        int currentCount = 0;
        for (Map.Entry<String, Integer> dataSet : numOccurrences.entrySet()) {
            if (dataSet.getValue() % 2 != 0) {
                currentCount++;

                if (countOdd == currentCount) {
                    System.out.print(dataSet.getKey());
                } else {
                    System.out.print(dataSet.getKey() + ", ");
                }

            }
        }

    }
}
