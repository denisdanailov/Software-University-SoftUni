package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int [] field = new int[n];
        
        int [] ladyBugsPosition = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).limit(n).toArray();

        for (int ladyBugIndex:
             ladyBugsPosition) {
            if (ladyBugIndex >= 0 && ladyBugIndex < n) {
                field[ladyBugIndex] = 1;
            }
        }

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flight = Integer.parseInt(tokens[2]);

            if (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                field[index] = 0;
                switch (direction) {
                    case "right":
                        index += flight;
                         while (index <= field.length - 1 && field[index] == 1) {
                          index += flight;
                         }
                         if (index <= field.length -1) {
                             field[index] = 1;
                         }
                        break;
                    case "left":
                        index -= flight;
                        while (index >= 0 && field[index] == 1) {
                            index -= flight;
                        }
                        if (index >= 0) {
                            field[index] = 1;
                        }
                        break;
                }
            }
            input = scan.nextLine();
        }

        Arrays.stream(field).forEach(a -> System.out.print(a + " "));
    }
}
