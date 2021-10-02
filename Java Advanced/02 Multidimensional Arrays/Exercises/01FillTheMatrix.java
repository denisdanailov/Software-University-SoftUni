package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");

        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];

        if (type.equals("A")) {
            matrix = createMatrixA(n);
        } else if (type.equals("B")) {
            matrix = createMatrixB(n);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int[][] createMatrixB(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count == 0) {
                    if (j == 0 && i == 0) {
                        matrix[j][i] = 1;
                    } else if (j == 0) {
                        matrix[j][i] = matrix[n - 1][i - 1] + 1;
                    } else {
                        matrix[j][i] = matrix[j - 1][i] + 1;
                    }
                } else if (count % 2 == 0) {
                    if (j == 0) {
                        matrix[j][i] = matrix[n - 1][i - 1] + n;
                    } else {
                        matrix[j][i] = matrix[j - 1][i] + 1;
                    }
                } else if (count % 2 != 0) {
                    if (j == 0) {
                        matrix[j][i] = matrix[n - 1][i - 1] + n;
                    } else {
                        matrix[j][i] = matrix[j - 1][i] - 1;
                    }
                }
            }
            count++;
        }
        return matrix;
    }

    private static int[][] createMatrixA(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i == 0) {
                    matrix[j][i] = 1;
                } else if (j == 0) {
                    matrix[j][i] = matrix[n - 1][i - 1] + 1;
                } else {
                    matrix[j][i] = matrix[j - 1][i] + 1;
                }
            }
        }
        return matrix;
    }
}
