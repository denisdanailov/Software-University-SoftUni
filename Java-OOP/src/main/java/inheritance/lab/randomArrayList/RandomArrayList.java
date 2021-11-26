package inheritance.lab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int endIndex = this.size();
        Random rand = new Random();
        int randIndex = rand.nextInt(endIndex);
        return this.remove(randIndex);
    }
}
