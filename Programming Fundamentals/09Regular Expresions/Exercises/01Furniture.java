package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = ">>(?<Furniture>[A-Za-z]+)<<(?<Price>\\d{3}\\.?\\d*)!(?<Quantity>\\d+)";
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0;
        double sum = 0;
        List<String> furnitureList = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furnitureList.add(matcher.group("Furniture"));
                double price = Double.parseDouble(matcher.group("Price"));
                int quantity = Integer.parseInt(matcher.group("Quantity"));
                totalPrice = price * quantity;
                sum += totalPrice;
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String item:
             furnitureList) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
