package Exams.JavaAdvancedExamFebruary2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int n = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] newLine = scan.nextLine().split(" ");
            matrix[i] = newLine;
        }
        // Logic
        int[] s = findSapper(matrix);
        List<int[]> listBombs = findAllBombs(matrix);
        boolean gameOver = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    moveUp(matrix, s);
                    break;
                case "right":
                    moveRight(matrix, s);
                    break;
                case "down":
                    moveDown(matrix, s);
                    break;
                case "left":
                    moveLeft(matrix, s);
                    break;
            }
            if (matrix[s[0]][s[1]].equals("B")) {
                System.out.println("You found a bomb!");
                matrix[s[0]][s[1]] = "+";
                removeBomb(listBombs, s);
            }
            if (matrix[s[0]][s[1]].equals("e")) {
                gameOver = true;
                break;
            }
//            matrix[s[0]][s[1]] = "s";
//            printMatrix(matrix);
        }
        // Print
        if (listBombs.isEmpty()) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (gameOver) {
            System.out.printf("END! %d bombs left on the field%n", listBombs.size());
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", listBombs.size(), s[0], s[1]);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("------------------------");
    }

    private static void removeBomb(List<int[]> listBombs, int[] s) {
        int index = -1;
        for (int i = 0; i < listBombs.size(); i++) {
            if (listBombs.get(i)[0] == s[0] && listBombs.get(i)[1] == s[1]) {
              index = i;
              break;
            }
        }
        if (index != -1) {
            listBombs.remove(index);
        }
    }

    private static void moveLeft(String[][] matrix, int[] s) {
        if (s[1] - 1 >= 0) {
            s[1] -= 1;
        } else {
            s[1] = 0;
        }
    }

    private static void moveDown(String[][] matrix, int[] s) {
        if (s[0] + 1 < matrix.length) {
            s[0] += 1;
        } else {
            s[0] = matrix.length - 1;
        }
    }

    private static void moveRight(String[][] matrix, int[] s) {
        if (s[1] + 1 < matrix[s[0]].length) {
            s[1] += 1;
        } else {
            s[1] = matrix[s[0]].length - 1;
        }
    }

    private static void moveUp(String[][] matrix, int[] s) {
        if (s[0] - 1 >= 0) {
            s[0] -= 1;
        } else {
            s[0] = 0;
        }
    }

    private static List<int[]> findAllBombs(String[][] matrix) {
        ArrayList<int[]> bombList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("B")) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    bombList.add(arr);
                }
            }
        }
        return bombList;
    }

    private static int[] findSapper(String[][] matrix) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
