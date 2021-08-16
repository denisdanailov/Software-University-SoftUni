package MockExamsPB.March2020;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());

        int countWinDays = 0;
        int countLostDays = 0;
        double totalMoneyWon = 0;
        boolean flag = false;

        for (int i = 0; i < days; i++) {
            String input = scan.nextLine();
            String gameName = "";
            String winOrLose = "";
            int sumWon = 0;
            int sumLost = 0;
            double moneyWon = 0;
            while (!input.equals("Finish")) {
                gameName = input;
                winOrLose = scan.nextLine();
                if (winOrLose.equals("win")) {
                    sumWon++;
                    moneyWon = sumWon * 20;
                } else {
                    sumLost++;
                }
                input = scan.nextLine();
            }
            if (sumWon > sumLost) {
                moneyWon += moneyWon * 0.10;
                totalMoneyWon += moneyWon;
                countWinDays++;
            } else {
                totalMoneyWon += moneyWon;
                countLostDays++;
            }
        }
        if (countWinDays > countLostDays) {
            totalMoneyWon += totalMoneyWon * 0.20;
            flag = true;
        }

        if (flag) {
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoneyWon);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoneyWon);
        }
    }
}
