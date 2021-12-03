package designPatterns.factory.interfaces;

public interface Factory {

    Pizza createPizza(String pizzaType, double diameter);
}
