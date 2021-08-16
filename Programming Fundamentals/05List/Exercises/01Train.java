package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbers = scan.nextLine();

        String[] values = numbers.split(" ");

        List<Integer> wagons = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            int wagon = Integer.parseInt(values[i]);
            wagons.add(wagon);
        }

        int maxNumPassengers = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            if (tokens[0].equals("Add")) {
            wagons.add(Integer.parseInt(tokens[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if ((wagons.get(i) + Integer.parseInt(tokens[0]) <= maxNumPassengers)){
                      wagons.set(i,wagons.get(i) + Integer.parseInt(tokens[0]));
                      break;
                    }
                }
            }
            input = scan.nextLine();
        }

        for (int wagon:
             wagons) {
            System.out.print(wagon + " ");
        }
    }
}
