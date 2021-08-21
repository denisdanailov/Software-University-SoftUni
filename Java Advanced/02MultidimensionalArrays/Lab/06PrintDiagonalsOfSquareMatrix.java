package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = createMatrix(n, scan);

        printDiagonalTopBottom(matrix);
        printDiagonalBottomTop(matrix);
    }

    private static void printDiagonalBottomTop(int[][] matrix) {
        int j = -1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            j++;
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }

    private static void printDiagonalTopBottom(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    private static int[][] createMatrix(int n, Scanner scan) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < array.length; j++) {
                matrix[i][j] = array[j];
            }
        }
        return matrix;
    }
}
