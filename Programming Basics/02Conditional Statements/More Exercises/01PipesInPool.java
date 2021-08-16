package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int volume = Integer.parseInt(scan.nextLine());
        int pipe1 = Integer.parseInt(scan.nextLine());
        int pipe2 = Integer.parseInt(scan.nextLine());
        double hours = Double.parseDouble(scan.nextLine());
        //Решение
        double p1H = pipe1 * hours;
        double p2H = pipe2 * hours;
        double totalLitres = p1H + p2H;
        //Проверки
        if (totalLitres > volume) {
            double overflowWith = totalLitres - volume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overflowWith);
        } else {
            double percentageFull = (totalLitres / volume) * 100;
            double percentageP1 = (p1H / totalLitres) * 100;
            double percentageP2 = (p2H / totalLitres) * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", percentageFull, percentageP1, percentageP2);
        }
    }
}
