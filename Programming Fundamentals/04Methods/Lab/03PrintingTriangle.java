package Methods.Labs;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
        
        printTriangle(n);
    }
    
    public static void printTriangle(int number) {
        printTopHalf(number);
        printBottomHalf(number);
    }
    
    public static void printTopHalf(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static void printBottomHalf(int number) {
        for (int i = number - 1; i >= 1 ; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
