package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        char[][] matrixA = createMatrix(rows, columns, scan);
        char[][] matrixB = createMatrix(rows, columns, scan);

        char[][] intersectionMatrix = createIntersectMatrix(rows, columns, matrixA, matrixB);

        Arrays.stream(intersectionMatrix)
                .forEach(element -> {
                    for (char character:
                         element) {
                        System.out.print(character + " ");
                    }
                    System.out.println("");
                });
    }

    private static char[][] createIntersectMatrix(int rows, int columns, char[][] matrixA, char[][] matrixB) {
        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                //Начин на записване 1: Тернарен оператор
                matrix[row][col] =
                        //Ако това условие е вярно if{}
                        matrixA[row][col] == matrixB[row][col]?
                                //запиши тази стойност
                                matrixA[row][col]:
                                // else{} запиши тази стойност
                                '*';

                //Начин на записване 2: If, else statement
//                if (matrixA[row][col] == matrixB[row][col]) {
//                    matrix[row][col] = matrixA[row][col];
//                } else {
//                    matrix[row][col] = '*';
//                }
            }
        }
        return matrix;
    }

    public static char[][] createMatrix(int rows, int columns, Scanner scan) {
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            char[] array = scan.nextLine().replace(" ", "").toCharArray();
            for (int j = 0; j < array.length; j++) {
                matrix[i][j] = array[j];
            }
        }
        return matrix;
    }
}
