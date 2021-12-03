package designPatterns.factory.pizzaTypes;

import designPatterns.factory.PizzaImpl;

public class ItalianPizza extends PizzaImpl {

    public ItalianPizza(double diameter) {
        super(diameter);
    }

    @Override
    public void preparePizza() {
        System.out.println("Prepare Italian style pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Put Italian pizza in the oven.");
    }

    @Override
    public void box() {
        System.out.println("Put Italian pizza in a box.");
    }
}
