package Methods.Labs;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scan.nextLine());
                int num2 = Integer.parseInt(scan.nextLine());
                System.out.println(getGreater(num1, num2));
                break;
            case "char":
                char char1 = scan.nextLine().charAt(0);
                char char2 = scan.nextLine().charAt(0);
                System.out.println(getGreater(char1, char2));
                break;
            case "string":
                String text1 = scan.nextLine();
                String text2 = scan.nextLine();
                System.out.println(getGreater(text1, text2));
                break;
        }
    }

    public static int getGreater(int a, int b) {
        if ( a >= b) {
            return a;
        }
        return b;

    }

    public static char getGreater(char a, char b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public static String getGreater(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }
}
