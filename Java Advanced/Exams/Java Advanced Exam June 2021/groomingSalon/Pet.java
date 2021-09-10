package JavaAdvancedExamJune2021.groomingSalon;

public class Pet {
    String name;
    int age;
    String owner;
    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }
    // Getters
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getOwner() {
        return this.owner;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age= age;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    // To String
    @Override
    public String toString() {
        return String.format("%s %d - (%s)", this.name, this.age, this.owner);
    }
}
