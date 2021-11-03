package encapsulation.exercises.pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaTokens = reader.readLine().split("\\s+");
            String pizzaName = pizzaTokens[1];
            int numberOfToppings = Integer.parseInt(pizzaTokens[2]);

            Pizza pizza = new Pizza(pizzaName,numberOfToppings);

            String[] doughTokens = reader.readLine().split("\\s+");
            String flourType = doughTokens[1];
            String backingTechnique = doughTokens[2];
            double weight = Double.parseDouble(doughTokens[3]);

            Dough dough = new Dough(flourType, backingTechnique, weight);
            pizza.setDough(dough);

            String input = reader.readLine();
            while (!input.equals("END")) {
                String[] tokens = input .split("\\s+");
                String toppingType = tokens[1];
                weight = Double.parseDouble(tokens[2]);

                Topping topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);

                input = reader.readLine();
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

    }
}
