package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
        char symbol = expression.charAt(i);
        if (symbol == '(') {
            stack.push(i);
        } else if (symbol == ')') {
            int firstIndex = stack.pop();
            String subExpression = expression.substring(firstIndex, i + 1);
            System.out.println(subExpression);
        }
        }
    }
}
