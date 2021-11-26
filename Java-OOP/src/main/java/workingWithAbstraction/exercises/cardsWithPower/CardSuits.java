package workingWithAbstraction.exercises.cardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    private CardSuits(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
