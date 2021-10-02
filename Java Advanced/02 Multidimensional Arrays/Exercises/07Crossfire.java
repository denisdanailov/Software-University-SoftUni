package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = inputArr[0];
        int cols = inputArr[1];
        String[][] matrix = createMatrix(rows, cols);
        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] inputArr2 = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = inputArr2[0];
            int col = inputArr2[1];
            int radius = inputArr2[2];
            matrix = bombCells(matrix,row,col,radius);
            input = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] bombCells(String[][] matrix, int row, int col, int radius) {
        matrix[row][col] = "Bombed";
        int rows = row;
        for (int i = 0; i < radius; i++) {
            rows++;
            if (rows < matrix.length && col < matrix[rows].length) {
                matrix[rows][col] = "Bombed";
            }
        }
        rows = row;
        for (int i = 0; i < radius; i++) {
            rows--;
            if (rows >= 0 && col < matrix[rows].length) {
                matrix[rows][col] = "Bombed";
            }
        }
        int cols = col;
        for (int i = 0; i < radius; i++) {
            cols++;
            if (cols < matrix[row].length) {
                matrix[row][cols] = "Bombed";
            }
        }
        cols = col;
        for (int i = 0; i < radius; i++) {
            cols--;
            if (cols >= 0) {
                matrix[row][cols] = "Bombed";
            }
        }

        return createNewMatrix(matrix);
    }

    private static String[][] createNewMatrix(String[][] matrix) {
        String[][] newMatrix = new String[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals("Bombed")) {
                   list.add(matrix[i][j]);
                }
            }
            String[] strArr = new String[list.size()];
            for (int index = 0; index < list.size(); index++) {
                strArr[index] = list.get(index);
            }
            newMatrix[i] = strArr;
        }
        return newMatrix;
    }

    private static String[][] createMatrix(int row, int col) {
        String[][] matrix = new String[row][col];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int number = n++;
                matrix[i][j] = Integer.toString(number);
            }
        }
        return matrix;
    }
}
