package Exams.MidExam.ProgrammingFundamentalsMidExamJuly21;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> models = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String action = tokens[0];
            String phone;
            String oldPhone;
            String newPhone;
            switch (action) {
                case "Add":
                    phone = tokens[1];
                    if (!models.contains(phone)) {
                        models.add(phone);
                    }
                    break;
                case "Remove":
                    phone = tokens[1];
                    models.remove(phone);
                    break;
                case "Bonus phone":
                    String[] phones = tokens[1].split(":");
                    oldPhone = phones[0];
                    newPhone = phones[1];
                    if (models.contains(oldPhone)) {
                        models.add(models.indexOf(oldPhone) + 1, newPhone);
                    }
                    break;
                case "Last":
                    phone = tokens[1];
                    if (models.contains(phone)) {
                        models.remove(phone);
                        models.add(phone);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < models.size(); i++) {
            if (i != models.size() - 1) {
                System.out.print(models.get(i) + ", ");
            } else {
                System.out.print(models.get(i));
            }
        }
    }
}
