package exams.javaOopExamApril2021.problem1.aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium{
    private final static int AQUARIUM_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, AQUARIUM_CAPACITY);
    }
}
