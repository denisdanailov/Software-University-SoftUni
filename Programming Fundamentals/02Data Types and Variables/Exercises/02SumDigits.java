package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        int num = Integer.parseInt(scan.nextLine());
//
//        int digit = 1;
//        int sumDigit = 0;
//
//        while (digit != 0) {
//            digit = num%10;
//            sumDigit += digit;
//            num = num/10;
//        }
//        Не работи при числа съдържащи 0 в тях пример: 1002

        String input = scan.nextLine();
        int sumDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = (int)input.charAt(i) - 48;
            sumDigit += digit;
        }

        System.out.println(sumDigit);
    }
}
