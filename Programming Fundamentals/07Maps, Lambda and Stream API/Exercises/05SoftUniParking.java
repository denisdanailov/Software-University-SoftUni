package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");

            switch (tokens[0]) {
                case "register":
                    if (parkingMap.containsKey(tokens[1])) {
                        System.out.println("ERROR: already registered with plate number " + tokens[2]);
                    } else {
                        parkingMap.put(tokens[1], tokens[2]);
                        System.out.printf("%s registered %s successfully%n", tokens[1], tokens[2]);
                    }
                    break;
                case "unregister":
                    if (parkingMap.containsKey(tokens[1])) {
                        parkingMap.remove(tokens[1]);
                        System.out.println(tokens[1] + " unregistered successfully");
                    } else {
                        System.out.printf("ERROR: user %s not found%n", tokens[1]);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> dataSet : parkingMap.entrySet()) {
            System.out.println(dataSet.getKey() + " => " + dataSet.getValue());
        }

    }
}
