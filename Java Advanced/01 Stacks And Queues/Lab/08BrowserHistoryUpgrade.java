package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String currUrl = "";

        ArrayDeque<String> backwardsStack = new ArrayDeque<String>();
        ArrayDeque<String> forwardsStack = new ArrayDeque<String>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backwardsStack.isEmpty() || backwardsStack.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardsStack.push(backwardsStack.pop());
                    System.out.println(backwardsStack.peek());
                }
            } else  if (input.equals("forward")) {
                if (forwardsStack.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardsStack.pop());
                }
            } else {
                currUrl = input;
                backwardsStack.push(currUrl);
                System.out.println(currUrl);
                forwardsStack.clear();
            }
            input = scan.nextLine();
        }
    }
}
