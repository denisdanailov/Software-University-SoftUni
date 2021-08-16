package Methods.Exercises;

import java.util.Scanner;

public class smallestOfThreeNumbers {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            int num1 = Integer.parseInt(scan.nextLine());
            int num2 = Integer.parseInt(scan.nextLine());
            int num3 = Integer.parseInt(scan.nextLine());

            int firstSmaller = smallestNum(num1, num2);
            int smallestNumber = smallestNum(firstSmaller, num3);

            System.out.print(smallestNumber);
        }

        public static int smallestNum(int a, int b) {
            if (a < b) {
                return a;
            }
            return b;
        }
    }
