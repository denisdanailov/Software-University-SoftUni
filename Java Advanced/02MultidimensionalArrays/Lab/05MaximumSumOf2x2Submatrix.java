package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = readArray(scan, ", ");

        int rows = array[0];
        int columns = array[1];

        int[][] matrix = createArray(rows, columns, scan);

        int[][] subMatrix = getMaxSumSubMatrix(matrix);

        printMatrix(subMatrix);
        int sum = getSumMatrix(subMatrix);
        System.out.println(sum);
    }

    private static int getSumMatrix(int[][] subMatrix) {
        int sum = 0;
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                sum += subMatrix[i][j];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] subMatrix) {
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int[][] getMaxSumSubMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[] row = new int[2];
        int[] col = new int[2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum = matrix[i][j] +
                        matrix[i][j + 1] +
                        matrix[i + 1][j] +
                        matrix[i + 1][j + 1];

                if (maxSum < sum) {
                    maxSum = sum;
                    row[0] = matrix[i][j];
                    row[1] = matrix[i][j + 1];
                    col[0] = matrix[i + 1][j];
                    col[1] = matrix[i + 1][j + 1];
                }
            }
        }

        return new int[][] {
                {row[0], row[1]},
                {col[0], col[1]}
        };
    }

    private static int[][] createArray(int rows, int columns, Scanner scan) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] newArr = readArray(scan, ", ");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = newArr[col];
            }
        }
        return matrix;
    }

    public static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}
