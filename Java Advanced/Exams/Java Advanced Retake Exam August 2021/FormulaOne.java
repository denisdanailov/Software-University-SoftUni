package Exams.JavaAdvancedRetakeExamAugust2021;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int num = Integer.parseInt(scan.nextLine());
        int actions = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[num][num];
        for (int i = 0; i < num; i++) {
            String[] newArr = scan.nextLine().split("");
            matrix[i] = newArr;
        }
        // Logic
        int[] p = findPlayer(matrix);
        int[] f = findFinish(matrix);
        boolean victory = false;
        while (actions-- > 0) {
            String action = scan.nextLine();
            matrix[p[0]][p[1]] = ".";
            switch (action) {
                case "down":
                    moveDown(matrix,p);
                    if (matrix[p[0]][p[1]].equals("B")) {
                        moveDown(matrix,p);
                    }
                    if (matrix[p[0]][p[1]].equals("T")) {
                        moveUp(matrix, p);
                    }
                    matrix[p[0]][p[1]] = "P";
                    break;
                case "right":
                    moveRight(matrix, p);
                    if (matrix[p[0]][p[1]].equals("B")) {
                        moveRight(matrix, p);
                    }
                    if (matrix[p[0]][p[1]].equals("T")) {
                        moveLeft(matrix, p);
                    }
                    matrix[p[0]][p[1]] = "P";
                    break;
                case "up":
                    moveUp(matrix, p);
                    if (matrix[p[0]][p[1]].equals("B")) {
                        moveUp(matrix, p);
                    }
                    if (matrix[p[0]][p[1]].equals("T")) {
                        moveDown(matrix,p);
                    }
                    matrix[p[0]][p[1]] = "P";
                    break;
                case "left":
                    moveLeft(matrix, p);
                    if (matrix[p[0]][p[1]].equals("B")) {
                        moveLeft(matrix, p);
                    }
                    if (matrix[p[0]][p[1]].equals("T")) {
                        moveRight(matrix, p);
                    }
                    matrix[p[0]][p[1]] = "P";
                    break;
            }
            if (playerReachedFinish(p, f)) {
                victory = true;
                break;
            }
        }
        if (victory) {
            System.out.println("Well done, the player won first place!");
            printMatrix(matrix);
        } else {
            System.out.println("Oh no, the player got lost on the track!");
            printMatrix(matrix);
        }
    }

    private static void moveLeft(String[][] matrix, int[] p) {
        if(p[1] - 1 >= 0) {
            p[1] -= 1;
        } else {
            p[1] = matrix[p[0]].length - 1;
        }
    }

    private static void moveUp(String[][] matrix, int[] p) {
        if(p[0] - 1 >= 0) {
            p[0] -= 1;
        } else {
            p[0] = matrix.length - 1;
        }
    }

    private static void moveRight(String[][] matrix, int[] p) {
        if(p[1] + 1 < matrix[p[0]].length) {
            p[1] += 1;
        } else {
            p[1] = 0;
        }
    }

    private static void moveDown(String[][] matrix, int[] p) {
        if(p[0] + 1 < matrix.length) {
            p[0] += 1;
        } else {
            p[0] = 0;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean playerReachedFinish(int[] player, int[] finish) {
        if (player[0] == finish[0] && player[1] == finish[1]) {
            return true;
        }
        return false;
    }

    private static int[] findFinish(String[][] matrix) {
        int[] coordinates = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("F")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }

    private static int[] findPlayer(String[][] matrix) {
        int[] coordinates = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }
}
