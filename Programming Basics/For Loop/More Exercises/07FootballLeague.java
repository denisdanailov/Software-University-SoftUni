package ForLoop.MoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stadium = Integer.parseInt(scan.nextLine());
        double fans = Integer.parseInt(scan.nextLine());

        double a1 = 0;
        double b1 = 0;
        double v1 = 0;
        double g1 = 0;

        for (int i = 0; i < fans; i++) {
            String sector = scan.nextLine();

            switch (sector) {
                case "A":
                    a1++;
                    break;
                case "B":
                    b1++;
                    break;
                case "V":
                    v1++;
                    break;
                case "G":
                    g1++;
                    break;
            }
        }

        double a1Percent = (a1 / fans) * 100;
        double b1Percent = (b1 / fans) * 100;
        double v1Percent = (v1 / fans) * 100;
        double g1Percent = (g1 / fans) * 100;
        double fansPercent = (fans / stadium) * 100;

        System.out.printf("%.2f%%%n", a1Percent);
        System.out.printf("%.2f%%%n", b1Percent);
        System.out.printf("%.2f%%%n", v1Percent);
        System.out.printf("%.2f%%%n", g1Percent);
        System.out.printf("%.2f%%%n", fansPercent);
    }
}
