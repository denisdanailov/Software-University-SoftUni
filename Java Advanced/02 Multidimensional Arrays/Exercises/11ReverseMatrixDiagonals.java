package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = inputArr[0];
        int cols = inputArr[1];
        String[][] matrix = createMatrix(rows, cols, scan);
        printReverseDiagonals(matrix, rows, cols);
    }

    private static void printReverseDiagonals(String[][] matrix, int rows, int cols) {
        int row = rows - 1;
        int col = cols - 1;
        while (row != -1) {
            int r = row;
            int c = col;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static String[][] createMatrix(int rows, int cols, Scanner scan) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
