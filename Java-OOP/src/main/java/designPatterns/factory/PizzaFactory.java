package designPatterns.factory;

import designPatterns.factory.interfaces.Factory;
import designPatterns.factory.interfaces.Pizza;
import designPatterns.factory.pizzaTypes.BulgarianPizza;
import designPatterns.factory.pizzaTypes.ItalianPizza;

public class PizzaFactory implements Factory {

    @Override
    public Pizza createPizza(String pizzaType, double diameter) {
        Pizza pizza = null;
        switch(pizzaType) {
            case "Italian Pizza":
                pizza = new ItalianPizza(diameter);
                break;
            case "Bulgarian Pizza":
                pizza = new BulgarianPizza(diameter);
                break;
        }
        return pizza;
    }
}
