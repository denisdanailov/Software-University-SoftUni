package exams.finalExamOopDecember2021.problem1.catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private final static int INITIAL_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        int currKilograms = super.getKilograms();
        super.setKilograms(currKilograms + 3);
    }
}
