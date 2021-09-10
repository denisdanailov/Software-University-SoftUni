package Exams.JavaAdvancedExamFebruary2020.guild;

public class Player {
    String name = "";
    String clazz = "";
    String rank;
    String description;
    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }
    //Getters
    public String getName() {
        return this.name;
    }
    public String getClazz() {
        return this.clazz;
    }
    public String getRank() {
        return this.rank;
    }
    public String getDescription() {
        return this.description;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //To String
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Player %s: %s%n", this.name, this.clazz));
        output.append(String.format("Rank: %s%n", this.rank));
        output.append(String.format("Description: %s", this.description));
        return output.toString();
    }
}
