package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = createMatrix(n, scan);

        int sumDiagonal1 = sumPrimaryDiagonal(matrix);
        int sumDiagonal2 = sumSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumDiagonal1 - sumDiagonal2));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int i = 0;
        int j = matrix[i].length - 1;
        int sum = 0;
        while (i < matrix.length && j >= 0) {
            sum += matrix[i][j];
            i += 1;
            j -= 1;
        }
        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int i = 0;
        int j = 0;
        int sum = matrix[i][j];
        while (i < matrix.length - 1 && j < matrix[i].length - 1) {
            i += 1;
            j += 1;
            sum += matrix[i][j];
        }
        return sum;
    }

    private static int[][] createMatrix(int n, Scanner scan) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }
}
