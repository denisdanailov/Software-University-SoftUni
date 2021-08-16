package Lists.Labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

      String firstInput = scan.nextLine();
      String secondInput = scan.nextLine();

      String[] firstInputValues = firstInput.split(" ");
      String[] secondInputValues = secondInput.split(" ");

      List<Integer> firstList = new ArrayList<>();
      List<Integer> secondList = new ArrayList<>();

        for (int i = 0; i < firstInputValues.length; i++) {
            int number = Integer.parseInt(firstInputValues[i]);
            firstList.add(number);
        }

        for (int i = 0; i < secondInputValues.length; i++) {
            int number = Integer.parseInt(secondInputValues[i]);
            secondList.add(number);
        }

        List<Integer> resultList = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstList.size() || secondIndex < secondList.size()) {

            if (firstIndex < firstList.size()) {
                resultList.add(firstList.get(firstIndex));
            }

            if (secondIndex < secondList.size()) {
                resultList.add(secondList.get(secondIndex));
            }

            firstIndex++;
            secondIndex++;
        }

        for (int number:
             resultList) {
            System.out.print(number + " ");
        }
    }
}
