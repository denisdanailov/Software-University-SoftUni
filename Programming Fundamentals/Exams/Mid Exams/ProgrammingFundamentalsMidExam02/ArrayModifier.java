package Exams.MidExam.ProgrammingFundamentalsMidExam02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String action = "";
        int index1 = 0;
        int index2 = 0;

        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            action = tokens[0];
            switch (action) {
                case "swap":
                    index1 = Integer.parseInt(tokens[1]);
                    index2 = Integer.parseInt(tokens[2]);
                    int treasury = inputArr[index2];
                    inputArr[index2] = inputArr[index1];
                    inputArr[index1] = treasury;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(tokens[1]);
                    index2 = Integer.parseInt(tokens[2]);
                    inputArr[index1] = inputArr[index1] * inputArr[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < inputArr.length; i++) {
                        inputArr[i] -= 1;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < inputArr.length; i++) {
            if (i != inputArr.length -1) {
                System.out.print(inputArr[i] + ", ");
            } else {
                System.out.print(inputArr[i]);
            }
        }
    }
}
