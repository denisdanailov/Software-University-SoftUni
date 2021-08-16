package AssociativeArrays.Exercise;


import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> employeeMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");

            if (!employeeMap.containsKey(tokens[0])) {
              employeeMap.put(tokens[0], new LinkedList<>());
            }

            if (!employeeMap.get(tokens[0]).contains(tokens[1])) {
                employeeMap.get(tokens[0]).add(tokens[1]);
            }

            input = scan.nextLine();
        }

        employeeMap.entrySet().stream()
                .sorted((a,b) -> a.getKey().compareTo(b.getKey()))
                .forEach(dataSet -> {
                    System.out.println(dataSet.getKey());
                   dataSet.getValue().stream().forEach(id -> System.out.println("-- " + id));
                });
    }
}
