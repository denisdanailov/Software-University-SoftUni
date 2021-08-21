package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rowsAndColumns = readArray(scan,",\\s+");

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = createMatrix(rows,columns,scan);

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(getSumAllMatrixElements(matrix));
    }

    private static int getSumAllMatrixElements(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] createMatrix(int rows, int columns, Scanner scan) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int[] rowInput = readArray(scan,",\\s+");
            for (int j = 0; j < rowInput.length; j++) {
                matrix[i][j] = rowInput[j];
            }
        }
        return matrix;
    }

    public static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}
