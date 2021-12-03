package designPatterns.strategy;

import designPatterns.strategy.flyStrategy.FlyStrategy;

public class Bird {
    private FlyStrategy flyStrategy;

    public Bird (FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void fly() {
        this.flyStrategy.fly();
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }
}
