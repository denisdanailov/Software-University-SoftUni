package exams.finalExamOopDecember2021.problem2.cats;

public class Cat {
    private String name;
    private boolean isHungry;

    public Cat(String name){
        this.setName(name);
        this.setHungry(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        this.isHungry = hungry;
    }
}