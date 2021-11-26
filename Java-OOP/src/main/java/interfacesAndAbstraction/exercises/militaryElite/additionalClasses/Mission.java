package interfacesAndAbstraction.exercises.militaryElite.additionalClasses;

import interfacesAndAbstraction.exercises.militaryElite.enums.State;

public class Mission {

    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = State.valueOf(state.toUpperCase());
    }

    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,
                this.state.name);
    }
}
