package designPatterns.strategy.flyStrategy;

public class FlyingInTheMountains implements FlyStrategy{

    @Override
    public void fly() {
        System.out.println("I'm flying in the mountain range.");
    }
}
