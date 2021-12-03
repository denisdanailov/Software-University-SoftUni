package designPatterns.builder;

public class Main {
    public static void main(String[] args) {

        LunchOrder finalOrder = LunchOrder.Builder.getInstance()
                .withStarter("Fish and Chips")
                .withSalad("Cesar")
                .withMain("Stake")
                .withDesert("Pancake")
                .withRefreshment("Lemonade")
                .build();


        Pizza pizza = new Pizza()
                .withName("Margarita")
                .withCrustType("Traditional")
                .withDiameter(35.0)
                .withSpicy(true)
                .withForTakeAway(false);
    }
}
