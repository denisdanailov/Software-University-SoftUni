
package workingWithAbstraction.exercises.greedyTimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long capacity = Long.parseLong(scan.nextLine());

        Bag bag = new Bag(capacity);

        String[] safe = scan.nextLine().split("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            long currAmount = Long.parseLong(safe[i + 1]);

            String name = safe[i];

            String item = defineItem(name);

            if (item.equals("")) {
                continue;
            } else if (capacity < bag.getAmount() + currAmount) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gold")) {
                            if (currAmount > bag.getItemAmount("Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getItemAmount(item) + currAmount > bag.getItemAmount("Gold")) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gem")) {
                            if (currAmount > bag.getItemAmount("Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getItemAmount(item) + currAmount > bag.getItemAmount("Gem")) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }

            bag.updateItem(item, name, currAmount);
        }

        // Print
        bag.printContents();
    }

    private static String defineItem(String name) {
        if (name.length() == 3) {
            return "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            return "Gold";
        } else {
            return "";
        }
    }
}