package Exams.JavaAdvancedRetakeExamAugust2020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = createMatrix(scan, n);

        int[] B = findBeeCoordinates(matrix);

        String action = scan.nextLine();
        boolean beeGotLost = false;
        int pollinatedFlowers = 0;
        while (!action.equals("End")) {
            matrix[B[0]][B[1]] = ".";
            switch (action) {
                case "up":
                    B[0] -= 1;
                    if (!isIndexValid(B, matrix)) {
                        break;
                    }
                    if (matrix[B[0]][B[1]].equals("O")) {
                        matrix[B[0]][B[1]] = ".";
                        B[0] -= 1;
                    }
                    if (matrix[B[0]][B[1]].equals("f")) {
                        pollinatedFlowers++;
                    }
                    break;
                case "down":
                    B[0] += 1;
                    if (!isIndexValid(B, matrix)) {
                        break;
                    }
                    if (matrix[B[0]][B[1]].equals("O")) {
                        matrix[B[0]][B[1]] = ".";
                        B[0] += 1;
                    }
                    if (matrix[B[0]][B[1]].equals("f")) {
                        pollinatedFlowers++;
                    }
                    break;
                case "right":
                    B[1] += 1;
                    if (!isIndexValid(B, matrix)) {
                        break;
                    }
                    if (matrix[B[0]][B[1]].equals("O")) {
                        matrix[B[0]][B[1]] = ".";
                        B[1] += 1;
                    }
                    if (matrix[B[0]][B[1]].equals("f")) {
                        pollinatedFlowers++;
                    }
                    break;
                case "left":
                    B[1] -= 1;
                    if (!isIndexValid(B, matrix)) {
                        break;
                    }
                    if (matrix[B[0]][B[1]].equals("O")) {
                        matrix[B[0]][B[1]] = ".";
                        B[1] -= 1;
                    }
                    if (matrix[B[0]][B[1]].equals("f")) {
                        pollinatedFlowers++;
                    }
                    break;
            }
            if (!isIndexValid(B, matrix)) {
                beeGotLost = true;
                break;
            }
            matrix[B[0]][B[1]] = "B";
            action = scan.nextLine();
        }

        // Print
        if (beeGotLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
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

    private static boolean isIndexValid(int[] B, String[][] matrix) {
        if (B[0] >= 0 && B[0] < matrix.length) {
            if (B[1] >= 0 && B[1] < matrix[B[0]].length) {
                return true;
            }
        }
        return false;
    }

    private static int[] findBeeCoordinates(String[][] matrix) {
        int[] B = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("B")) {
                    B[0] = i;
                    B[1] = j;
                }
            }
        }
        return B;
    }

    private static String[][] createMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        return matrix;
    }
}
