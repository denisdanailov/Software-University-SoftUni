package Exams.MidExam.ProgrammingFundamentalsMidExam01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());


        String input = scan.nextLine();

        boolean isWinner = false;
        int countMoves = 0;

        while (!input.equals("end")) {
            countMoves += 1;
            String[] tokens = input.split(" ");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);
            if (areIndexesValid(index1, index2, inputList)) {
                if (inputList.get(index1).equals(inputList.get(index2))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", inputList.get(index1));
                    if (index1 < index2) {
                        inputList.remove(index2);
                        inputList.remove(index1);
                    } else {
                        inputList.remove(index1);
                        inputList.remove(index2);
                    }
                    if (inputList.size() == 0) {
                        isWinner = true;
                        break;
                    }
                } else {
                    System.out.println("Try again!");
                }
            } else {
                String penaltyElement = String.format("-%da", countMoves);
                int midIndex = inputList.size() / 2;
                inputList.add(midIndex, penaltyElement);
                inputList.add(midIndex, penaltyElement);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            input = scan.nextLine();
        }

        if (isWinner) {
         System.out.printf("You have won in %d turns!%n", countMoves);
        } else {
            System.out.println("Sorry you lose :(");
            for (int i = 0; i < inputList.size(); i++) {
                if (i != inputList.size() - 1) {
                    System.out.print(inputList.get(i) + " ");
                } else {
                    System.out.print(inputList.get(i));
                }
            }
        }
    }

    public static boolean areIndexesValid (int index1, int index2, List<String> list) {
        if (index1 >= 0 && index2 >= 0 && index1 < list.size() && index2 < list.size() && index1 != index2) {
            return true;
        } else {
            return false;
        }
    }
}
