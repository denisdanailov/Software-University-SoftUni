package designPatterns.strategy.flyStrategy;

public class FlyingNearBeach implements FlyStrategy{

    @Override
    public void fly() {
        System.out.println("I'm flying near the beach.");
    }
}
