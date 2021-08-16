package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int counter = 0;
        String resource = "";

        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            counter++;

            if (counter % 2 != 0) {
                resource = input;
            } else {
                int quantity = Integer.parseInt(input);

                if (resourceMap.containsKey(resource)) {
                    int currQuant = resourceMap.get(resource);
                    resourceMap.replace(resource,currQuant + quantity);
                } else {
                    resourceMap.put(resource, quantity);
                }
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, Integer> dataSet : resourceMap.entrySet()) {
            System.out.println(dataSet.getKey() + " -> " + dataSet.getValue());
        }

    }
}
