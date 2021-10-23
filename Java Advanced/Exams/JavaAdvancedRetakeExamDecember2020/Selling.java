package Exams.JavaAdvancedRetakeExamDecember2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = readMatrix(scan, n);

        int[] S = findSCoordinates(matrix);
        List<int[]> portals = findPortalCoordinates(matrix);

        boolean isOutOfBakery = false;
        boolean isSum50 = false;

        int sum = 0;
        while (!isOutOfBakery && !isSum50) {
            String direction = scan.nextLine();
            matrix[S[0]][S[1]] = "-";
            switch (direction) {
                case "up":
                    S[0] -= 1;
                    if (!isValidCoordinates(S, matrix)) {
                        isOutOfBakery = true;
                    } else {
                        if (matrix[S[0]][S[1]].equals("O")) {
                            if (portals.get(0)[0] == S[0] && portals.get(0)[1] == S[1]) {
                                S[0] = portals.get(1)[0];
                                S[1] = portals.get(1)[1];
                            } else {
                                S[0] = portals.get(0)[0];
                                S[1] = portals.get(0)[1];
                            }
                            matrix[portals.get(0)[0]][portals.get(0)[1]] = "-";
                            matrix[portals.get(1)[0]][portals.get(1)[1]] = "-";
                        } else if (Character.isDigit(matrix[S[0]][S[1]].charAt(0))) {
                            sum += Integer.parseInt(matrix[S[0]][S[1]]);
                            if (sum >= 50) {
                                isSum50 = true;
                            }
                        }
                        matrix[S[0]][S[1]] = "S";
                    }
                    break;
                case "down":
                    S[0] += 1;
                    if (!isValidCoordinates(S, matrix)) {
                        isOutOfBakery = true;
                    } else {
                        if (matrix[S[0]][S[1]].equals("O")) {
                            if (portals.get(0)[0] == S[0] && portals.get(0)[1] == S[1]) {
                                S[0] = portals.get(1)[0];
                                S[1] = portals.get(1)[1];
                            } else {
                                S[0] = portals.get(0)[0];
                                S[1] = portals.get(0)[1];
                            }
                            matrix[portals.get(0)[0]][portals.get(0)[1]] = "-";
                            matrix[portals.get(1)[0]][portals.get(1)[1]] = "-";
                        } else if (Character.isDigit(matrix[S[0]][S[1]].charAt(0))) {
                            sum += Integer.parseInt(matrix[S[0]][S[1]]);
                            if (sum >= 50) {
                                isSum50 = true;
                            }
                        }
                        matrix[S[0]][S[1]] = "S";
                    }
                    break;
                case "left":
                    S[1] -= 1;
                    if (!isValidCoordinates(S, matrix)) {
                        isOutOfBakery = true;
                    } else {
                        if (matrix[S[0]][S[1]].equals("O")) {
                            if (portals.get(0)[0] == S[0] && portals.get(0)[1] == S[1]) {
                                S[0] = portals.get(1)[0];
                                S[1] = portals.get(1)[1];
                            } else {
                                S[0] = portals.get(0)[0];
                                S[1] = portals.get(0)[1];
                            }
                            matrix[portals.get(0)[0]][portals.get(0)[1]] = "-";
                            matrix[portals.get(1)[0]][portals.get(1)[1]] = "-";
                        } else if (Character.isDigit(matrix[S[0]][S[1]].charAt(0))) {
                            sum += Integer.parseInt(matrix[S[0]][S[1]]);
                            if (sum >= 50) {
                                isSum50 = true;
                            }
                        }
                        matrix[S[0]][S[1]] = "S";
                    }
                    break;
                case "right":
                    S[1] += 1;
                    if (!isValidCoordinates(S, matrix)) {
                        isOutOfBakery = true;
                    } else {
                        if (matrix[S[0]][S[1]].equals("O")) {
                            if (portals.get(0)[0] == S[0] && portals.get(0)[1] == S[1]) {
                                S[0] = portals.get(1)[0];
                                S[1] = portals.get(1)[1];
                            } else {
                                S[0] = portals.get(0)[0];
                                S[1] = portals.get(0)[1];
                            }
                            matrix[portals.get(0)[0]][portals.get(0)[1]] = "-";
                            matrix[portals.get(1)[0]][portals.get(1)[1]] = "-";
                        } else if (Character.isDigit(matrix[S[0]][S[1]].charAt(0))) {
                            sum += Integer.parseInt(matrix[S[0]][S[1]]);
                            if (sum >= 50) {
                                isSum50 = true;
                            }
                        }
                        matrix[S[0]][S[1]] = "S";
                    }
                    break;
            }
        }

        // Print
        if (isOutOfBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (isSum50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", sum);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    private static boolean isValidCoordinates(int[] S, String[][] matrix) {
        if (S[0] >= 0 && S[0] < matrix.length) {
            if (S[1] >= 0 && S[1] < matrix[S[0]].length) {
                return true;
            }
        }
        return false;
    }

    private static List<int[]> findPortalCoordinates(String[][] matrix) {
        List<int[]> portals = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("O")) {
                    int[] O = new int[2];
                    O[0] = i;
                    O[1] = j;
                    portals.add(O);
                }
            }
        }
        return portals;
    }

    private static int[] findSCoordinates(String[][] matrix) {
        int[] S = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    S[0] = i;
                    S[1] = j;
                }
            }
        }
        return S;
    }

    private static String[][] readMatrix(Scanner scan, int n) {
        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        return matrix;
    }
}
