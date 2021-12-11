package exams.finalExamOopDecember2021.problem1.catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private final static int INITIAL_KILOGRAMS = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        int currKilograms = super.getKilograms();
        super.setKilograms(currKilograms + 1);
    }
}
