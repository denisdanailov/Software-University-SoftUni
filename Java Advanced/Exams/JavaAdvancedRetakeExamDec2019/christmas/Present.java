package Exams.JavaAdvancedRetakeExamDec2019.christmas;

public class Present {
    String name;
    double weight;
    String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        return String.format("Present %s (%.2f) for a %s", this.name, this.weight, this.gender);
    }
}
