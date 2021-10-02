package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        ArrayDeque<Character> closedBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
                openBrackets.offer(input.charAt(i));
            } else if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
                closedBrackets.push(input.charAt(i));
            }
        }

        boolean areBalanced = false;
        if (openBrackets.size() == closedBrackets.size()) {
            while (!openBrackets.isEmpty() || !closedBrackets.isEmpty()) {
                char a = openBrackets.poll();
                char b = closedBrackets.pop();
                if (a == '{' && b == '}') {
                    areBalanced = true;
                } else if (a == '[' && b == ']') {
                    areBalanced = true;
                } else if (a == '(' && b == ')') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
