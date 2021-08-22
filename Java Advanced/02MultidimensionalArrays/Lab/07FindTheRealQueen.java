package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] matrix = createMatrix(scan);

        int[] coordinates = findTheRealQueen(matrix);

        Arrays.stream(coordinates).forEach(a -> System.out.print(a + " "));
    }

    private static int[] findTheRealQueen(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    if (!checkForQueenColumn(matrix, i, j)) {
                        if (!checkForQueenRow(matrix, i, j)) {
                            if (!checkForQueenDiagonalTopBottom(matrix, i, j)) {
                                if (!checkForQueenDiagonalBottomTop(matrix, i, j)) {
                                    return new int[] {i, j};
                                }
                            }
                        }
                    }
                }
            }
        }
        return new int[] {0, 0};
    }

    private static boolean checkForQueenDiagonalBottomTop(char[][] matrix, int row, int column) {
        int row1 = row;
        if (row1 - 1 >= 0) {
            row1--;
        }
        for (int i = column + 1; i < matrix[row1].length; i++) {
            if (matrix[row1][i] == 'q') {
                return true;
            }
            if (row1 - 1 >= 0) {
                row1--;
            } else {
                break;
            }
        }
        int row2 = row;
        if (row2 + 1 < matrix.length) {
            row2++;
        }
        for (int i = column - 1; i >= 0; i--) {
            if (matrix[row2][i] == 'q') {
                return true;
            }
            if (row2 + 1 < matrix.length) {
                row2++;
            }
        }
        return false;
    }

    private static boolean checkForQueenDiagonalTopBottom(char[][] matrix, int row, int column) {
        int col1 = column;
        if (col1 + 1 < matrix[row].length) {
            col1++;
        }
        for (int i = row+1; i < matrix.length; i++) {
            if (matrix[i][col1] == 'q') {
                return true;
            }
            if (col1 + 1 < matrix[i].length-1) {
                col1++;
            }
        }
        int col2 = column;
        if (col2 -1 >= 0) {
            col2--;
        }
        for (int i = row -1; i >= 0; i--) {
            if (matrix[i][col2] == 'q') {
                return true;
            }
            if (col2 - 1 >= 0) {
                col2--;
            } else {
                break;
            }
        }
        return false;
    }

    private static boolean checkForQueenRow(char[][] matrix, int row, int column) {
        for (int i = row+1; i < matrix.length; i++) {
            if (matrix[i][column] == 'q') {
                return true;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            if (matrix[i][column] == 'q') {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForQueenColumn(char[][] matrix, int row, int column) {
        for (int i = column + 1; i < matrix.length; i++) {
            if (matrix[row][i] == 'q') {
                return true;
            }
        }
        for (int i = column - 1; i >= 0; i--) {
            if (matrix[row][i] == 'q') {
                return true;
            }
        }
        return false;
    }

    private static char[][] createMatrix(Scanner scan) {
        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().replace(" ", "").toCharArray();
        }
        return matrix;
    }
}
