package designPatterns.strategy;

import designPatterns.strategy.flyStrategy.CantFly;
import designPatterns.strategy.flyStrategy.FlyingInTheMountains;
import designPatterns.strategy.flyStrategy.FlyingNearBeach;

public class Main {
    public static void main(String[] args) {

        // Injecting a dependency for the flying algorithm
        Bird eagle = new Bird(new FlyingInTheMountains());
        eagle.fly();

        // Injecting a dependency for the flying algorithm
        Bird seagull = new Bird(new FlyingNearBeach());
        seagull.fly();

        // Injecting a dependency for the flying algorithm
        Bird penguin = new Bird(new CantFly());
        penguin.fly();

        // Setting new fly strategy for the penguin
        penguin.setFlyStrategy(new FlyingNearBeach());
        penguin.fly();

    }
}
