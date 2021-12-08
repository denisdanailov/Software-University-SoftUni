package exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double INITIAL_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        double currEnergy = super.getEnergy();
        if (currEnergy - 7 <= 0) {
            super.setEnergy(0);
        } else {
            super.setEnergy(currEnergy -= 7);
        }
    }
}
