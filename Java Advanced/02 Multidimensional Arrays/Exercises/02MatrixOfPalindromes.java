package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = input[0];
        int cols = input[1];

        String[][] matrix = createMatrix(rows, cols);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static String[][] createMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] charArr = new char[3];
            for (int j = 0; j < cols; j++) {
                charArr[0] = (char) (97 + i);
                charArr[1] = (char) (97 + (i + j));
                charArr[2] = (char) (97 + i);
                matrix[i][j] = charToString(charArr);
            }
        }
        return matrix;
    }

    private static String charToString(char[] charArr) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            output.append(charArr[i]);
        }
        return output.toString();
    }
}
