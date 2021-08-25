package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> nameMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            if (nameMap.containsKey(name)) {
                nameMap.get(name).add(grade);
            } else {
                List<Double> gradeList = new ArrayList<>();
                gradeList.add(grade);
                nameMap.put(name,gradeList);
            }
        }

        for (Map.Entry<String, List<Double>> entry : nameMap.entrySet()) {
            double sum = 0;
            double avgGrade = 0;
            for (Double grade : entry.getValue()) {
                sum += grade;
            }
            avgGrade = sum / entry.getValue().size();
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(grade -> System.out.printf("%.2f ",grade));
            System.out.printf("(avg: %.2f)%n", avgGrade);
        }

    }
}
