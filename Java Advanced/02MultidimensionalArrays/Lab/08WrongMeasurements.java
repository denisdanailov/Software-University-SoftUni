package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = createMatrix(rows, scan);

        int[][] correctedMatrix = correctMatrix(matrix, scan);

        printMatrix(correctedMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .forEach(element -> {
                    Arrays.stream(element)
                            .forEach(integer -> System.out.print(integer + " "));
                    System.out.println();
                });
    }

    private static int[][] correctMatrix(int[][] matrix, Scanner scan) {
        int wrongValue = findWrongValue(matrix, scan);
        List<int[]> coordinates = findAllCoordinates(matrix, wrongValue);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int newValue = 0;
                    //Числото отгоре
                    if (i - 1 >= 0 && !wrongCoordinates(coordinates,i-1, j)) {
                        newValue += matrix[i - 1][j];
                    }
                    //Числото отдясно
                    if (j + 1 < matrix[i].length && !wrongCoordinates(coordinates,i,j+1)) {
                        newValue += matrix[i][j + 1];
                    }
                    //Числото отдолу
                    if (i + 1 < matrix.length && !wrongCoordinates(coordinates,i+1, j)) {
                        newValue += matrix[i + 1][j];
                    }
                    //Числото отляво
                    if (j - 1 >= 0 && !wrongCoordinates(coordinates,i,j-1)) {
                        newValue += matrix[i][j - 1];
                    }
                    matrix[i][j] = newValue;
                }
            }
        }
        return matrix;
    }

    private static boolean wrongCoordinates(List<int[]> coordinates, int row, int column) {
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i)[0] == row && coordinates.get(i)[1]==column) {
                return true;
            }
        }
        return false;
    }

    private static List<int[]> findAllCoordinates(int[][] matrix, int wrongValue) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int[] newArr = {i, j};
                    list.add(newArr);
                }
            }
        }
        return list;
    }

    private static int findWrongValue(int[][] matrix, Scanner scan) {
        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        return matrix[coordinates[0]][coordinates[1]];
    }

    private static int[][] createMatrix(int rows, Scanner scan) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
