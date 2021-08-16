package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+(.\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);

        String input = scan.nextLine();
        double sum = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                String name = matcher.group("name");
                String product = matcher.group("product");

                System.out.printf("%s: %s - %.2f%n", name, product, quantity * price);

                sum += quantity * price;
            }

            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f%n", sum);
    }
}
