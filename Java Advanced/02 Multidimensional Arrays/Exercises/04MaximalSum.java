package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = readArray(scan);
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = createMatrix(rows, cols, scan);

        int[][] winnerMatrix = findWinnerMatrix(matrix);

        System.out.println("Sum = " + findSumMatrix(winnerMatrix));
        printMatrix(winnerMatrix);
    }

    private static int[][] findWinnerMatrix(int[][] matrix) {
        int[][] winnerMatrix = new int[3][3];
        int greaterSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 2 < matrix.length && j + 2 < matrix[i].length) {
                    int[][] newMatrix = new int[3][3];
                    int currRow = i;
                    int currCol = j;
                    for (int row = 0; row < 3; row++) {
                        for (int column = 0; column < 3; column++) {
                            newMatrix[row][column] = matrix[currRow][currCol];
                            currCol++;
                        }
                        currRow++;
                        currCol = j;
                    }
                    int sumMatrix = findSumMatrix(newMatrix);
                    if (greaterSum < sumMatrix) {
                        greaterSum = sumMatrix;
                        winnerMatrix = newMatrix;
                    }
                }
            }
        }
        return winnerMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findSumMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] createMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scan);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
