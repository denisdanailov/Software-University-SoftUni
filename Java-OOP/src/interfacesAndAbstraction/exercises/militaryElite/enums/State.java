package interfacesAndAbstraction.exercises.militaryElite.enums;

public enum State {

    INPROGRESS("inProgress"),
    FINISHED("finished");

    public String name;

    State(String name) {
        this.name = name;
    }
}
