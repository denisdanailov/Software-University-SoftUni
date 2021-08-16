package Exams.MidExam.ProgrammingFundamentalsMidExam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> list = new ArrayList<>();

        for (int number:
             inputArr) {
            list.add(number);
        }

        double averageValue = Arrays.stream(inputArr).average().getAsDouble();

        list.stream()
                .filter(a -> a > averageValue)
                .sorted((a,b) -> Integer.compare(b,a))
                .limit(5)
                .forEach(a -> System.out.print(a + " "));

        if (!isValidList(inputArr)) {
            System.out.println("No");
        }
    }

    public static boolean isValidList(int[] arr) {
        double averageValue = Arrays.stream(arr).average().getAsDouble();
        boolean isValid = false;
        for (int num:
             arr) {
            if (num > averageValue) {
                isValid = true;
            }
        }
        return isValid;
    }
}
