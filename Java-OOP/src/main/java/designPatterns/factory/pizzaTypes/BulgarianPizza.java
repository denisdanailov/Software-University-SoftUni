package designPatterns.factory.pizzaTypes;

import designPatterns.factory.PizzaImpl;

public class BulgarianPizza extends PizzaImpl {

    public BulgarianPizza(double diameter) {
        super(diameter);
    }

    @Override
    public void preparePizza() {
        System.out.println("Prepare Bulgarian style Pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Put Bulgarian style pizza in the oven.");
    }

    @Override
    public void box() {
        System.out.println("Put Bulgarian style pizza in a box.");
    }
}
