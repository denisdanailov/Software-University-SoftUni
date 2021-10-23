package Exams.JavaAdvancedExamJune2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = createMatrix(scan, n);

        int[] S = findCoordinates(matrix, "S");

        int foodCount = 0;
        boolean isOutOfTerritory = false;
        while (!isOutOfTerritory && foodCount < 10) {
            String action = scan.nextLine();
            matrix[S[0]][S[1]] = ".";
            switch (action) {
                case "up":
                    S[0] -= 1;
                    if (!checkValidCoordinates(S, matrix)) {
                        isOutOfTerritory = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("B")) {
                        matrix[S[0]][S[1]] = ".";
                        int[] burrowCoordinate = findCoordinates(matrix, "B");
                        S[0] = burrowCoordinate[0];
                        S[1] = burrowCoordinate[1];
                    }
                    if (matrix[S[0]][S[1]].equals("*")) {
                        foodCount++;
                    }
                    break;
                case "down":
                    S[0] += 1;
                    if (!checkValidCoordinates(S, matrix)) {
                        isOutOfTerritory = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("B")) {
                        matrix[S[0]][S[1]] = ".";
                        int[] burrowCoordinate = findCoordinates(matrix, "B");
                        S[0] = burrowCoordinate[0];
                        S[1] = burrowCoordinate[1];
                    }
                    if (matrix[S[0]][S[1]].equals("*")) {
                        foodCount++;
                    }
                    break;
                case "right":
                    S[1] += 1;
                    if (!checkValidCoordinates(S, matrix)) {
                        isOutOfTerritory = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("B")) {
                        matrix[S[0]][S[1]] = ".";
                        int[] burrowCoordinate = findCoordinates(matrix, "B");
                        S[0] = burrowCoordinate[0];
                        S[1] = burrowCoordinate[1];
                    }
                    if (matrix[S[0]][S[1]].equals("*")) {
                        foodCount++;
                    }
                    break;
                case "left":
                    S[1] -= 1;
                    if (!checkValidCoordinates(S, matrix)) {
                        isOutOfTerritory = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("B")) {
                        matrix[S[0]][S[1]] = ".";
                        int[] burrowCoordinate = findCoordinates(matrix, "B");
                        S[0] = burrowCoordinate[0];
                        S[1] = burrowCoordinate[1];
                    }
                    if (matrix[S[0]][S[1]].equals("*")) {
                        foodCount++;
                    }
                    break;
            }
            if (isOutOfTerritory) {
                break;
            }
            matrix[S[0]][S[1]] = "S";
        }

        // Print
        if (isOutOfTerritory) {
            System.out.println("Game over!");
        }

        if (foodCount >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + foodCount);

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

    private static boolean checkValidCoordinates(int[] arr, String[][] matrix) {
        if (arr[0] >= 0 && arr[0] < matrix.length) {
            if (arr[1] >= 0 && arr[1] < matrix[arr[0]].length) {
                return true;
            }
        }
        return false;
    }

    private static int[] findCoordinates(String[][] matrix, String element) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(element)) {
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
}
