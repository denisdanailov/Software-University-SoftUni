package Methods.Labs;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());

        System.out.println(repeatString(input, n));
    }

    public static String repeatString(String text, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += text;
        }
        return result;
    }
}
