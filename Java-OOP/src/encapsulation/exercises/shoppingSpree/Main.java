package encapsulation.exercises.shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] personArr = reader.readLine().split(";");
        String[] productArr = reader.readLine().split(";");

        Map<String, Person> peopleMap = new LinkedHashMap<>();
        for (int i = 0; i < personArr.length; i++) {
            String name = personArr[i].split("=")[0];
            double money = Double.parseDouble(personArr[i].split("=")[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }

        Map<String, Product> productsMap = new LinkedHashMap<>();
        for (int i = 0; i < productArr.length; i++) {
            String name = productArr[i].split("=")[0];
            double cost = Double.parseDouble(productArr[i].split("=")[1]);
            try {
                Product product = new Product(name, cost);
                productsMap.put(name, product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }

        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Person currPerson = peopleMap.get(personName);
            Product currProduct = productsMap.get(productName);

            try {
                currPerson.buyProduct(currProduct);
                System.out.printf("%s bought %s%n", currPerson.getName(), currProduct.getName());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            input = reader.readLine();
        }


        peopleMap.forEach((key, value) -> {
            System.out.print(key + " - ");
            if (!value.getProducts().isEmpty()) {
                System.out.print(value.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
            } else {
                System.out.print("Nothing bought");
            }
            System.out.println();
        });

    }
}
