package Methods.Labs;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());
        double pow = Double.parseDouble(scan.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(num, pow)));
    }

    public static double mathPower(double num, double pow) {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= num;
        }
        return result;
    }
}
