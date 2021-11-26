package workingWithAbstraction.exercises.cardsWithPower;

public class Card {

    public static int calcPower(String rank, String suit) {
        int suitPow = CardSuits.valueOf(suit).getPower();
        int rankPow = CardRank.valueOf(rank).getPower();

        return rankPow + suitPow;
    }
}
