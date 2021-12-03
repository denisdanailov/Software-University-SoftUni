package designPatterns.factory;

import designPatterns.factory.interfaces.Pizza;

public abstract class PizzaImpl implements Pizza {
    private double diameter;

    public PizzaImpl(double diameter) {
        this.diameter = diameter;
    }
}
