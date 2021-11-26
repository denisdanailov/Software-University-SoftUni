package workingWithAbstraction.exercises.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int[] dimensions = readIntArray(input, " ");
        int x = dimensions[0];
        int y = dimensions[1];

        Galaxy galaxy = new Galaxy(x, y);

        long sum = 0;

        input = scan.nextLine();
        while (!input.equals("Let the Force be with you")) {

            int[] jediCoordinates = readIntArray(input, " ");
            Jedi jedi = new Jedi(jediCoordinates);

            input = scan.nextLine();
            int[] evilCoordinates = readIntArray(input, " ");
            Evil evil = new Evil(evilCoordinates);

            // Evil destroys stars and returns Matrix
            galaxy = evil.destroyStars(galaxy);

            // Jedi collects the stars
            jedi.collectStars(galaxy);

            sum += jedi.getStarsCollected();

            input = scan.nextLine();
        }

        System.out.println(sum);

    }

    private static int[] readIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }
}
