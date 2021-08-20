package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String currUrl = "";

        ArrayDeque<String> stack = new ArrayDeque<String>();
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                currUrl = input;
                stack.push(currUrl);
                System.out.println(currUrl);
            } else {
                if (stack.isEmpty() || stack.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }
            input = scan.nextLine();
        }
    }
}
