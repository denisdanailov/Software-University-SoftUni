package Exams.JavaAdvancedExamOctober2021RegularExam;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = createMatrix(scan, n);

        int[] M = findCoordinates(matrix, "M");

        String action = scan.nextLine();
        int cheeseEaten = 0;
        boolean isOutOfMatrix = false;

        while (!action.equals("end")) {
            matrix[M[0]][M[1]] = "-";

            M = moveMouse(M, matrix, action);

            if (!checkValidIndex(M, matrix)) {
                isOutOfMatrix = true;
                break;
            }
            if (matrix[M[0]][M[1]].equals("c")) {
                cheeseEaten++;
            }
            if (matrix[M[0]][M[1]].equals("B")) {
                matrix[M[0]][M[1]] = "-";
                M = moveMouse(M, matrix, action);
                if (!checkValidIndex(M, matrix)) {
                    isOutOfMatrix = true;
                    break;
                }
                if (matrix[M[0]][M[1]].equals("c")) {
                    cheeseEaten++;
                }
            }

            matrix[M[0]][M[1]] = "M";
            action = scan.nextLine();
        }

        // Print
        if (isOutOfMatrix) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    private static boolean checkValidIndex(int[] arr, String[][] matrix) {
        if (arr[0] >= 0 && arr[0] < matrix.length) {
            if (arr[1] >= 0 && arr[1] < matrix[arr[0]].length) {
                return true;
            }
        }
        return false;
    }

    private static int[] findCoordinates(String[][] matrix, String letter) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(letter)) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    private static String[][] createMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        return matrix;
    }


    private static int[] moveMouse(int[] M, String[][] matrix, String action) {
        switch (action) {
            case "up" -> M[0] -= 1;
            case "down" -> M[0] += 1;
            case "left" -> M[1] -= 1;
            case "right" -> M[1] += 1;
        }
        return M;
    }
}
