package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = readIntArr(scan);

        int firstElement = inputArr[0];
        int secondElement = inputArr[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        fillFirstSet(firstSet, firstElement, scan);

        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        fillSecondSet(secondSet, secondElement, scan);
        // Version 1:Iterate both sets and check for duplicates
        LinkedHashSet<Integer> duplicateElements = createSet(firstSet, secondSet);
        printMatchingElements(duplicateElements);
        // Version 2:Use retainAll () method
//        firstSet.retainAll(secondSet);
//        printMatchingElements(firstSet);
    }

    private static void printMatchingElements(LinkedHashSet<Integer> set) {
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }

    }

    private static LinkedHashSet<Integer> createSet(LinkedHashSet<Integer> firstSet, LinkedHashSet<Integer> secondSet) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                set.add(integer);
            }
        }

        return set;
    }

    private static void fillSecondSet(LinkedHashSet<Integer> secondSet, int secondElement, Scanner scan) {
        for (int i = 0; i < secondElement; i++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }
    }

    private static void fillFirstSet(LinkedHashSet<Integer> firstSet, int firstElement, Scanner scan) {
        for (int i = 0; i < firstElement; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }
    }

    private static int[] readIntArr(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
