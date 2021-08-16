package AssociativeArrays.Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> courseMap = new LinkedHashMap<>();


        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");

            if (!courseMap.containsKey(tokens[0])) {
                courseMap.put(tokens[0],new LinkedList<>());
            }
            courseMap.get(tokens[0]).add(tokens[1]);
            input = scan.nextLine();
        }

        courseMap.entrySet().stream()
                .sorted((a1,a2) -> a2.getValue().size() - a1.getValue().size())
                .forEach(dataSet -> {
                    System.out.println(dataSet.getKey() + ": " + dataSet.getValue().size());
                    dataSet.getValue()
                            .stream()
                            .sorted((a1,a2) -> a1.compareTo(a2))
                            .forEach(name -> System.out.println("-- " + name));
                });

    }
}
