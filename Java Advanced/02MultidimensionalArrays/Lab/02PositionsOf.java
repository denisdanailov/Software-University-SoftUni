package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rowsAndColumns = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndColumns[0];
        int columns = rowsAndColumns[1];

        int[][] matrix = createMatrix(rows, columns, scan);

        int number = Integer.parseInt(scan.nextLine());

        boolean numFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    numFound = true;
                }
            }
        }

        if (!numFound) {
            System.out.println("not found");
        }
    }

    public static int[][] createMatrix(int rows, int columns, Scanner scan) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
//            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt).toArray();
            int[] columnArray = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < columnArray.length; col++) {
                matrix[row][col] = columnArray[col];
            }
        }
        return matrix;
    }
}
