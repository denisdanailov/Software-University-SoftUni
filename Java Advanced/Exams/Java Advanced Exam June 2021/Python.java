package JavaAdvancedExamJune2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int n = Integer.parseInt(scan.nextLine());
        String[] directions = scan.nextLine().split(",\\s+");
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] newRow = scan.nextLine().split("\\s+");
            matrix[i] = newRow;
        }
        // Logic
        int[] s = findSnake(matrix);
        int length = 1;
        int countF = getFoodCount(matrix);
        boolean gameOver = false;
        for (String direction : directions) {
            switch (direction) {
                case "up" -> moveUp(matrix, s);
                case "down" -> moveDown(matrix, s);
                case "left" -> moveLeft(matrix, s);
                case "right" -> moveRight(matrix, s);
            }
            if (matrix[s[0]][s[1]].equals("f")) {
                countF--;
                length++;
            }
            if (matrix[s[0]][s[1]].equals("e")) {
                gameOver = true;
                break;
            }
        }
        //  Print
        if (gameOver) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (countF <= 0) {
            System.out.printf("You win! Final python length is %d%n", length);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countF);
        }
    }

    private static int getFoodCount(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static void moveRight(String[][] matrix, int[] s) {
        if (s[1] + 1 < matrix[s[0]].length) {
            s[1] += 1;
        } else {
            s[1] = 0;
        }
    }

    private static void moveLeft(String[][] matrix, int[] s) {
        if (s[1] - 1 >= 0) {
            s[1] -= 1;
        } else {
            s[1] = matrix[s[0]].length - 1;
        }
    }

    private static void moveDown(String[][] matrix, int[] s) {
        if (s[0] + 1 < matrix.length) {
            s[0] += 1;
        } else {
            s[0] = 0;
        }
    }

    private static void moveUp(String[][] matrix, int[] s) {
        if (s[0] - 1 >= 0) {
            s[0] -= 1;
        } else {
            s[0] = matrix.length - 1;
        }
    }

    private static int[] findSnake(String[][] matrix) {
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
