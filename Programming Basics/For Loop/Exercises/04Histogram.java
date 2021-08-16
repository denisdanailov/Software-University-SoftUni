package ForLoop.Exercises;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double p1Sum = 0;
        double p2Sum = 0;
        double p3Sum = 0;
        double p4Sum = 0;
        double p5Sum = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(scan.nextLine());

            if (num < 200) {
                p1Sum++;
            } else if (num >= 200 && num <= 399) {
                p2Sum++;
            } else if (num >= 400 && num <= 599) {
                p3Sum++;
            } else if (num >= 600 && num <= 799) {
                p4Sum++;
            } else if (num >= 800) {
                p5Sum++;
            }
        }

        double p1 = (p1Sum / n) * 100;
        double p2 = (p2Sum / n) * 100;
        double p3 = (p3Sum / n) * 100;
        double p4 = (p4Sum / n) * 100;
        double p5 = (p5Sum / n) * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
        System.out.printf("%.2f%%%n", p4);
        System.out.printf("%.2f%%%n", p5);
    }
}
