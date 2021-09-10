package Exams.JavaAdvancedExamFebruary2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int n = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());
        // Logic
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scan.nextLine().split("");
            matrix[i] = row;
        }
        int[] f = findPlayer(matrix);
        int[] F = findFinishLine(matrix);
        boolean victory = false;
        while (countCommands-- > 0) {
            String action = scan.nextLine();
            matrix[f[0]][f[1]] = "-";
            switch (action) {
                case "down":
                    moveDown(matrix,f);
                    if (matrix[f[0]][f[1]].equals("B")) {
                        moveDown(matrix, f);
                    }
                    if (matrix[f[0]][f[1]].equals("T")) {
                        moveUp(matrix, f);
                    }
                    matrix[f[0]][f[1]] = "f";
                    break;
                case "left":
                    moveLeft(matrix, f);
                    if (matrix[f[0]][f[1]].equals("B")) {
                        moveLeft(matrix, f);
                    }
                    if (matrix[f[0]][f[1]].equals("T")) {
                        moveRight(matrix, f);
                    }
                    matrix[f[0]][f[1]] = "f";
                    break;
                case "right":
                    moveRight(matrix, f);
                    if (matrix[f[0]][f[1]].equals("B")) {
                        moveRight(matrix, f);
                    }
                    if (matrix[f[0]][f[1]].equals("T")) {
                        moveLeft(matrix, f);
                    }
                    matrix[f[0]][f[1]] = "f";
                    break;
                case "up":
                    moveUp(matrix, f);
                    if (matrix[f[0]][f[1]].equals("B")) {
                        moveUp(matrix, f);
                    }
                    if (matrix[f[0]][f[1]].equals("T")) {
                        moveDown(matrix, f);
                    }
                    matrix[f[0]][f[1]] = "f";
                    break;
            }
            if (isVictory(f, F)) {
                victory = true;
                break;
            }
        }
        // Print
        if (victory) {
           System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static boolean isVictory(int[] f, int[] F) {
        if (f[0] == F[0] && f[1] == F[1]) {
            return true;
        }
        return false;
    }

    private static void moveUp(String[][] matrix, int[] f) {
        if (f[0] - 1 >= 0) {
            f[0] -= 1;
        } else {
            f[0] = matrix.length - 1;
        }
    }

    private static void moveRight(String[][] matrix, int[] f) {
        if (f[1] + 1 < matrix[f[0]].length) {
            f[1] += 1;
        } else {
            f[1] = 0;
        }
    }

    private static void moveLeft(String[][] matrix, int[] f) {
        if (f[1] - 1 >= 0) {
            f[1] -= 1;
        } else {
            f[1] = matrix[f[0]].length - 1;
        }
    }

    private static void moveDown(String[][] matrix, int[] f) {
        if (f[0] + 1 < matrix.length) {
            f[0] += 1;
        } else {
            f[0] = 0;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] findFinishLine(String[][] matrix) {
        int[] coordinates = new int[2];
        boolean finishFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("F")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    finishFound = true;
                    break;
                }
                if (finishFound) {
                    break;
                }
            }
        }
        return coordinates;
    }

    private static int[] findPlayer(String[][] matrix) {
        int[] coordinates = new int[2];
        boolean playerFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    playerFound = true;
                    break;
                }
            }
            if (playerFound) {
                break;
            }
        }
        return coordinates;
    }
}
