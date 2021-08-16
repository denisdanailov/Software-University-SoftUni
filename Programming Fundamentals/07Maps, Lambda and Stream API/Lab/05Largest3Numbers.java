package AssociativeArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split(" "))
                .map(i -> Integer.parseInt(i))
                .sorted((a,b) -> Integer.compare(b,a))
                .limit(3)
                .forEach(i -> System.out.print(i + " "));
    }
}
