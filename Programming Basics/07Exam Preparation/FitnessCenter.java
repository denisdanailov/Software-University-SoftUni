package PreExamPreparation;

import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int visitors = Integer.parseInt(scan.nextLine());

        String activity = "";

        double countBack = 0;
        double countChest = 0;
        double countLegs = 0;
        double countAbs = 0;
        double countPS = 0;
        double countPB = 0;

        for (int i = 1; i <= visitors; i++) {
            activity = scan.nextLine();
            switch (activity) {
                case "Back":
                    countBack++;
                    break;
                case "Chest":
                    countChest++;
                    break;
                case "Legs":
                    countLegs++;
                    break;
                case "Abs":
                    countAbs++;
                    break;
                case "Protein shake":
                    countPS++;
                    break;
                case "Protein bar":
                    countPB++;
                    break;
            }
        }

        double workoutPercent = ((countBack + countChest + countLegs + countAbs) / visitors) * 100;
        double proteinPercent = ((countPS + countPB) / visitors) * 100;
        System.out.printf("%.0f - back%n", countBack);
        System.out.printf("%.0f - chest%n", countChest);
        System.out.printf("%.0f - legs%n", countLegs);
        System.out.printf("%.0f - abs%n", countAbs);
        System.out.printf("%.0f - protein shake%n", countPS);
        System.out.printf("%.0f - protein bar%n", countPB);
        System.out.printf("%.2f%% - work out%n", workoutPercent);
        System.out.printf("%.2f%% - protein%n", proteinPercent);
    }
}
