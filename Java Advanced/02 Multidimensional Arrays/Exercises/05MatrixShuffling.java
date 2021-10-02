package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        // Read  & Create Matrix
        Scanner scan = new Scanner(System.in);
        int[] inputRowAndCol = readIntArray(scan);
        int row = inputRowAndCol[0];
        int col = inputRowAndCol[1];
        String[][] matrix = createIntArray(row, col, scan);
        // Logic
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            if (isValidSwap(tokens, matrix)) {
                matrix = swapElements(tokens, matrix);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swapElements(String[] tokens, String[][] matrix) {
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);
        String firstElement = matrix[row1][col1];
        String secondElement = matrix[row2][col2];
        matrix[row1][col1] = secondElement;
        matrix[row2][col2] = firstElement;
        return matrix;
    }

    private static boolean isValidSwap(String[] tokens, String[][] matrix) {
        if (!tokens[0].equals("swap")) {
            return false;
        }
        if (tokens.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);
        if (row1 < 0 || row1 >= matrix.length) {
            return false;
        }
        if (row2 < 0 || row2 >= matrix.length) {
            return false;
        }
        if (col1 < 0 || col1 >= matrix[row1].length) {
            return false;
        }
        if (col2 < 0 || col2 >= matrix[row2].length) {
            return false;
        }
        return true;
    }

    private static String[][] createIntArray(int row, int col, Scanner scan) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static int[] readIntArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
