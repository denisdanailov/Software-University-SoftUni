package exams.javaOopExamApril2021.problem1.aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private final static int INITIAL_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        int currSize = super.getSize();
        super.setSize(currSize += 3);
    }
}
