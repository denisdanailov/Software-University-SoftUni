package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());

        //решения
        double lengthCm= length*100;
        double widthCm = width*100;

        double widthMinusCorridor = widthCm-100;
        double deskPerWidth = (int)(widthMinusCorridor/70);
        double deskPerLength = (int)(lengthCm/120);

        double totalDesks =(deskPerLength * deskPerWidth)-3;

        //Принтиране
        System.out.printf("%.0f",totalDesks);
    }
}
