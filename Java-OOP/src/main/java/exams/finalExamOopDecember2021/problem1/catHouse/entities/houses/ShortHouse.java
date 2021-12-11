package exams.finalExamOopDecember2021.problem1.catHouse.entities.houses;

public class ShortHouse extends BaseHouse{
    private final static int HOUSE_CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, HOUSE_CAPACITY);
    }
}
