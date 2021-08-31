package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<Double, Double> addVat = x -> x * 1.2;

        double[] pricesWithVat = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .map(addVat::apply)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(pricesWithVat).forEach(e -> System.out.printf("%.2f%n", e));
    }
}
