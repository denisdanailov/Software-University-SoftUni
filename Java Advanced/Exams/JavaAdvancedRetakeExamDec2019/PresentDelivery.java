package Exams.JavaAdvancedRetakeExamDec2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countPresents = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = createMatrix(scan, n);

        int[] S = findCoordinates(matrix, "S");
        List<int[]> niceKidsList = createList(matrix);

        int niceKidsWithPresents = 0;
        boolean santaRanOutOfPresents = false;
        String action = scan.nextLine();
        while (!action.equals("Christmas morning")) {
            matrix[S[0]][S[1]] = "-";
            switch (action) {
                case "up":
                    S[0] -= 1;
                    if (!checkIfValidIndexes(S[0], S[1], matrix)) {
                        santaRanOutOfPresents = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("V")) {
                        countPresents--;
                        niceKidsWithPresents++;
                    }
                    if (matrix[S[0]][S[1]].equals("C")) {
                        // Down from Santa
                        if (checkIfValidIndexes(S[0] + 1, S[1], matrix)) {
                            if (matrix[S[0] + 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] + 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Up from Santa
                        if (checkIfValidIndexes(S[0] - 1, S[1], matrix)) {
                            if (matrix[S[0] - 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] - 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Right from santa
                        if (checkIfValidIndexes(S[0], S[1] + 1, matrix)) {
                            if (matrix[S[0]][S[1] + 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] + 1].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Left from Santa
                        if (checkIfValidIndexes(S[0], S[1] - 1, matrix)) {
                            if (matrix[S[0]][S[1] - 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] - 1].equals("X")) {
                                countPresents--;
                            }
                        }
                    }
                    break;
                case "down":
                    S[0] += 1;
                    if (!checkIfValidIndexes(S[0], S[1], matrix)) {
                        santaRanOutOfPresents = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("V")) {
                        countPresents--;
                        niceKidsWithPresents++;
                    }
                    if (matrix[S[0]][S[1]].equals("C")) {
                        // Down from Santa
                        if (checkIfValidIndexes(S[0] + 1, S[1], matrix)) {
                            if (matrix[S[0] + 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] + 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Up from Santa
                        if (checkIfValidIndexes(S[0] - 1, S[1], matrix)) {
                            if (matrix[S[0] - 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] - 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Right from santa
                        if (checkIfValidIndexes(S[0], S[1] + 1, matrix)) {
                            if (matrix[S[0]][S[1] + 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] + 1].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Left from Santa
                        if (checkIfValidIndexes(S[0], S[1] - 1, matrix)) {
                            if (matrix[S[0]][S[1] - 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] - 1].equals("X")) {
                                countPresents--;
                            }
                        }
                    }
                    break;
                case "right":
                    S[1] += 1;
                    if (!checkIfValidIndexes(S[0], S[1], matrix)) {
                        santaRanOutOfPresents = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("V")) {
                        countPresents--;
                        niceKidsWithPresents++;
                    }
                    if (matrix[S[0]][S[1]].equals("C")) {
                        // Down from Santa
                        if (checkIfValidIndexes(S[0] + 1, S[1], matrix)) {
                            if (matrix[S[0] + 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] + 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Up from Santa
                        if (checkIfValidIndexes(S[0] - 1, S[1], matrix)) {
                            if (matrix[S[0] - 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] - 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Right from santa
                        if (checkIfValidIndexes(S[0], S[1] + 1, matrix)) {
                            if (matrix[S[0]][S[1] + 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] + 1].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Left from Santa
                        if (checkIfValidIndexes(S[0], S[1] - 1, matrix)) {
                            if (matrix[S[0]][S[1] - 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] - 1].equals("X")) {
                                countPresents--;
                            }
                        }
                    }
                    break;
                case "left":
                    S[1] -= 1;
                    if (!checkIfValidIndexes(S[0], S[1], matrix)) {
                        santaRanOutOfPresents = true;
                        break;
                    }
                    if (matrix[S[0]][S[1]].equals("V")) {
                        countPresents--;
                        niceKidsWithPresents++;
                    }
                    if (matrix[S[0]][S[1]].equals("C")) {
                        // Down from Santa
                        if (checkIfValidIndexes(S[0] + 1, S[1], matrix)) {
                            if (matrix[S[0] + 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] + 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Up from Santa
                        if (checkIfValidIndexes(S[0] - 1, S[1], matrix)) {
                            if (matrix[S[0] - 1][S[1]].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0] - 1][S[1]].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Right from santa
                        if (checkIfValidIndexes(S[0], S[1] + 1, matrix)) {
                            if (matrix[S[0]][S[1] + 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] + 1].equals("X")) {
                                countPresents--;
                            }
                        }
                        // Left from Santa
                        if (checkIfValidIndexes(S[0], S[1] - 1, matrix)) {
                            if (matrix[S[0]][S[1] - 1].equals("V")) {
                                countPresents--;
                                niceKidsWithPresents++;
                            }
                            if (matrix[S[0]][S[1] - 1].equals("X")) {
                                countPresents--;
                            }
                        }
                    }
                    break;
            }
            matrix[S[0]][S[1]] = "S";
            if (countPresents <= 0) {
                break;
            } else {
                action = scan.nextLine();
            }
        }

        // Print
        if (countPresents <= 0 || santaRanOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        if (niceKidsList.size() == niceKidsWithPresents) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKidsWithPresents);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsList.size() - niceKidsWithPresents);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static List<int[]> createList(String[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("V")) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    list.add(arr);
                }
            }
        }
        return list;
    }

    private static boolean checkIfValidIndexes(int i, int j, String[][] matrix) {
        if (i >= 0 && i < matrix.length) {
            if (j >= 0 && j < matrix[i].length) {
                return true;
            }
        }
        return false;
    }

    private static int[] findCoordinates(String[][] matrix, String element) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(element)) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }

    private static String[][] createMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
