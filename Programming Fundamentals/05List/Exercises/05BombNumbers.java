package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] values = input.split(" ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            int number = Integer.parseInt(values[i]);
            list.add(number);
        }

        String input2 = scan.nextLine();

        String[] tokens = input2.split(" ");
        int specialNumber = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (list.contains(specialNumber)) {
          int index = list.indexOf(specialNumber);

          int leftBound = Math.max(0, index - power);
          int rightBound = Math.min(list.size() - 1, index + power);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);
            }

        }

        int sum = 0;
        for (int num:
             list) {
            sum += num;
        }
        System.out.println(sum);
    }
}
