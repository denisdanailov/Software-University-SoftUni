package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<String>();
        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                String documentName = input;
                queue.offer(documentName);
            } else {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledDoc = queue.poll();
                    System.out.println("Canceled " + canceledDoc);
                }
            }
            input = scan.nextLine();
        }

        for (String document:
                queue) {
            System.out.println(document);
        }
    }
}
