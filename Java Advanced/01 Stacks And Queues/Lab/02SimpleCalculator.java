package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputArr = scan.nextLine().split(" ");

        Deque<String> stack = new ArrayDeque<String>();
        Collections.addAll(stack,inputArr);

//        Алтернатива на Collections.addAll(stack, inputArr);
//        for (int i = inputArr.length - 1; i >= 0 ; i--) {
//            stack.push(inputArr[i]);
//        }

        while (stack.size() > 1) {
            int firstInt = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondInt = Integer.parseInt(stack.pop());
            int result = 0;
            switch (operator) {
                case "+":
                    result = firstInt + secondInt;
                    stack.push(Integer.toString(result));
                    break;
                case "-":
                    result = firstInt - secondInt;
                    stack.push(Integer.toString(result));
                    break;
            }
        }

        System.out.println(stack.peek());
    }
}
