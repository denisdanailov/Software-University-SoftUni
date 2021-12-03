package designPatterns.factory;

import designPatterns.factory.interfaces.Factory;
import designPatterns.factory.interfaces.Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pizzaType = scan.nextLine();
        double diameter = Double.parseDouble(scan.nextLine());

        Factory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza(pizzaType, diameter);

        pizza.preparePizza();
        pizza.bake();
        pizza.box();
    }


}
