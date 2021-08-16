package Exams.MidExam.ProgrammingFundamentalsMidExamRetakeAug19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> treasury = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input =scan.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            switch (action) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                       String item = tokens[i];
                       if (!treasury.contains(item)) {
                           treasury.add(0, item);
                       }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < treasury.size()) {
                        String itemToRemove = treasury.get(index);
                        treasury.remove(itemToRemove);
                        treasury.add(itemToRemove);
                    }
                    break;
                case "Steal":
                    int stolenItemsNumber = Integer.parseInt(tokens[1]);
                    int firstItemToRemove = treasury.size() - 1;
                    int lastItemToRemove = (treasury.size() - 1) - stolenItemsNumber;
                    List<String> stolenItems = new ArrayList<>();
                    if (lastItemToRemove < 0) {
                        for (int i = firstItemToRemove; i >= 0 ; i--) {
                            String stolenItem = treasury.get(i);
                            treasury.remove(i);
                            stolenItems.add(0, stolenItem);
                        }
                    } else {
                        for (int i = firstItemToRemove; i > lastItemToRemove; i--) {
                            String stolenItem = treasury.get(i);
                            treasury.remove(i);
                            stolenItems.add(0, stolenItem);
                        }
                    }
                    for (int i = 0; i < stolenItems.size(); i++) {
                        if (i != stolenItems.size() - 1) {
                            System.out.print(stolenItems.get(i) + ", ");
                        } else {
                            System.out.print(stolenItems.get(i));
                            System.out.println();
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }

        double sumTreasures = 0;
        for (String item:
             treasury) {
            sumTreasures += item.length();
        }

        if (sumTreasures != 0) {
            double averageTreasureGain = sumTreasures / treasury.size();
            System.out.printf("Average treasure gain: %.02f pirate credits.%n", averageTreasureGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
