package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Orders {

    static class Order {
        double price;
        int quantity;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] tokens = input.split(" ");

        Map<String, Order> orderMap = new LinkedHashMap<>();

        while (!tokens[0].equals("buy")) {
            Order currOrder = new Order();
            currOrder.price = Double.parseDouble(tokens[1]);
            currOrder.quantity = Integer.parseInt(tokens[2]);

            if (!orderMap.containsKey(tokens[0])) {
                orderMap.put(tokens[0], currOrder);
            } else {
            int curr = orderMap.get(tokens[0]).quantity;
            currOrder.quantity = curr + Integer.parseInt(tokens[2]);
            orderMap.replace(tokens[0], currOrder);
            }

            input = scan.nextLine();
            tokens = input.split(" ");
        }

        for (Map.Entry<String, Order> dataSet : orderMap.entrySet()) {
            double totalPrice = dataSet.getValue().price * dataSet.getValue().quantity;
            String product = dataSet.getKey();
            System.out.printf("%s -> %.2f%n", product, totalPrice);
        }

    }
}
