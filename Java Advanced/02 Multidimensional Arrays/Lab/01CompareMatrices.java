package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<int[][]> matrixList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int[] rowsAndColumns = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int rows = rowsAndColumns[0];
            int columns = rowsAndColumns[1];

            int[][] newMatrix = assertMatrix(rows, columns, scan);

            matrixList.add(newMatrix);
        }

        if (areMatrixesEqual(matrixList)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] assertMatrix(int rows, int columns, Scanner scan) {
        int[][] newMatrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            //Примерен начин 1 за записване на матрица
            // newMatrix[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            //Примерен начин 2 - моя начин
            int[] newColumn = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < newColumn.length; col++) {
                newMatrix[row][col] = newColumn[col];
            }
        }
        return newMatrix;
    }
    public static boolean areMatrixesEqual(List<int[][]> matrixList) {
        if (matrixList.get(0).length != matrixList.get(1).length) {
            return false;
        }
        for (int i = 0; i < matrixList.get(0).length; i++) {
            int[] firstMatrixElement = matrixList.get(0)[i];
            int[] secondMatrixElement = matrixList.get(1)[i];
            if (firstMatrixElement.length != secondMatrixElement.length) {
             return false;
            }
            for (int j = 0; j < firstMatrixElement.length; j++) {
                if (firstMatrixElement[j] != secondMatrixElement[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
