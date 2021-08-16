package AssociativeArrays.Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> gradeMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if(!gradeMap.containsKey(name)) {
                gradeMap.put(name,new ArrayList<>());
            }

            gradeMap.get(name).add(grade);
        }

        gradeMap.entrySet().stream()
                .sorted((f,s) -> {
                    double firstAvg = f.getValue().stream()
                            .mapToDouble(Double::doubleValue)
                            .average().getAsDouble();

                    double secondAvg = s.getValue().stream()
                            .mapToDouble(Double::doubleValue)
                            .average().getAsDouble();

                    return Double.compare(secondAvg, firstAvg);
                })
                .filter(a -> {
                    double grade = a.getValue().stream().mapToDouble(Double::doubleValue)
                            .average().getAsDouble();

                    return grade >= 4.50;
                })
                .forEach(a -> {
                    double grade = a.getValue().stream().mapToDouble(Double::doubleValue)
                            .average().getAsDouble();
                   System.out.printf("%s -> %.2f%n", a.getKey(), grade);
                });
    }
}
