package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        // Read Degrees
        Scanner scan = new Scanner(System.in);
        String rotation = scan.nextLine();
        int degrees = findDegrees(rotation);
        // Read & Create Matrix
        String input = scan.nextLine();
        List<String> elementList = new ArrayList<>();
        while (!input.equals("END")) {
            elementList.add(input);
            input = scan.nextLine();
        }
        int rows = elementList.size();
        int cols = findLongestString(elementList);
        String[][] matrix = createMatrix(elementList, rows, cols);
        // Rotate Matrix
        rotatePrintMatrix(matrix, rows, cols, degrees);
    }

    private static void rotatePrintMatrix(String[][] matrix, int rows, int cols, int degrees) {
        if (degrees == 90) {
            for (int col = 0; col < cols ; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = rows - 1; row >= 0 ; row--) {
                for (int col = cols - 1; col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows ; row++) {
                    System.out.print(matrix[row][col]);

                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows ; row++) {
                for (int col = 0; col < cols ; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static String[][] createMatrix(List<String> elementList, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            String[] tokens = elementList.get(i).split("");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = tokens[j];
            }
        }
        return matrix;
    }

    private static int findLongestString(List<String> elementList) {
        int size = 0;
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).length() > size) {
                size = elementList.get(i).length();
            }
        }
        return size;
    }

    private static int findDegrees(String input) {
        StringBuilder degrees = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                degrees.append(input.charAt(i));
            }
        }
        return Integer.parseInt(degrees.toString());
    }
}
