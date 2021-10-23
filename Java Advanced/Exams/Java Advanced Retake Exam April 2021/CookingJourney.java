package Exams.JavaAdvancedRetakeExamApril2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read Matrix
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            char[] newLine = readNewLine(input);
            matrix[i] = newLine;
        }
        // Logic
        boolean goesToTheVoid = false;
        int[] S = findPlayer(matrix);
        List<int[]> P = findPillars(matrix);
        int sumMoney = 0;
        while (!goesToTheVoid && sumMoney < 50) {
            String action = scan.nextLine();
            matrix[S[0]][S[1]] = '-';
            switch (action) {
                case "up":
                    goesToTheVoid = moveUp(matrix,S);
                    if (!goesToTheVoid && !P.isEmpty()) {
                        steppedOnAPillar(matrix, P, S);
                    }
                    if (Character.isDigit(matrix[S[0]][S[1]])) {
                        sumMoney += Character.getNumericValue(matrix[S[0]][S[1]]);
                        matrix[S[0]][S[1]] = 'S';
                    }
                    break;
                case "right":
                    goesToTheVoid = moveRight(matrix, S);
                    if (!goesToTheVoid && !P.isEmpty()) {
                        steppedOnAPillar(matrix, P, S);
                    }
                    if (Character.isDigit(matrix[S[0]][S[1]])) {
                        sumMoney += Character.getNumericValue(matrix[S[0]][S[1]]);
                        matrix[S[0]][S[1]] = 'S';
                    }
                    break;
                case "down":
                    goesToTheVoid = moveDown(matrix, S);
                    if (!goesToTheVoid && !P.isEmpty()) {
                        steppedOnAPillar(matrix, P, S);
                    }
                    if (Character.isDigit(matrix[S[0]][S[1]])) {
                        sumMoney += Character.getNumericValue(matrix[S[0]][S[1]]);
                        matrix[S[0]][S[1]] = 'S';
                    }
                    break;
                case "left":
                    goesToTheVoid = moveLeft(matrix, S);
                    if (!goesToTheVoid && !P.isEmpty()) {
                        steppedOnAPillar(matrix, P, S);
                    }
                    if (Character.isDigit(matrix[S[0]][S[1]])) {
                        sumMoney += Character.getNumericValue(matrix[S[0]][S[1]]);
                        matrix[S[0]][S[1]] = 'S';
                    }
                    break;
            }
        }
        if (goesToTheVoid) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else if (sumMoney >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", sumMoney);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[] readNewLine(String input) {
        char[] arr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }
        return arr;
    }

    private static boolean steppedOnAPillar(char[][] matrix, List<int[]> P, int[] S) {
        if (S[0] == P.get(0)[0] && S[1] == P.get(0)[1]) {
            S[0] = P.get(1)[0];
            S[1] = P.get(1)[1];
            matrix[P.get(0)[0]][P.get(0)[1]] = '-';
            matrix[P.get(1)[0]][P.get(1)[1]] = 'S';
            P.clear();
            return true;
        } else if (S[0] == P.get(1)[0] && S[1] == P.get(1)[1]) {
            S[0] = P.get(0)[0];
            S[1] = P.get(0)[1];
            matrix[P.get(0)[0]][P.get(0)[1]] = 'S';
            matrix[P.get(1)[0]][P.get(1)[1]] = '-';
            P.clear();
            return true;
        }
        return false;
    }

    private static boolean moveLeft(char[][] matrix, int[] S) {
        if (S[1] - 1 >= 0) {
            S[1] -= 1;
            return false;
        }
        return true;
    }

    private static boolean moveDown(char[][] matrix, int[] S) {
        if (S[0] + 1 < matrix.length) {
            S[0] += 1;
            return false;
        }
        return true;
    }

    private static boolean moveRight(char[][] matrix, int[] S) {
        if (S[1] + 1 < matrix[S[0]].length) {
            S[1] += 1;
            return false;
        }
        return true;
    }

    private static boolean moveUp(char[][] matrix,int[] S) {
        if (S[0] - 1 >= 0) {
            S[0] -= 1;
            return false;
        }
        return true;
    }

    private static ArrayList<int[]> findPillars(char[][] matrix) {
        ArrayList<int[]> pillarList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='P') {
                    int[] newArr = new int[2];
                    newArr[0] = i;
                    newArr[1] = j;
                    pillarList.add(newArr);
                }
            }
        }
        return pillarList;
    }

    private static int[] findPlayer(char[][] matrix) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='S') {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
