package NestedLoops.Labs;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        char type = 0;

        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {

                if (i == floors) {
                    type = 'L';
                } else if (i % 2 == 0) {
                    type = 'O';
                } else {
                    type = 'A';
                }

                System.out.printf("%c%d%d ", type, i, j);

                if (j == rooms-1) {
                    System.out.println("");
                }

            }
        }
    }
}
