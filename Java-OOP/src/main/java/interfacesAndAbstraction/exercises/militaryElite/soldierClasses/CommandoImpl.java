package interfacesAndAbstraction.exercises.militaryElite.soldierClasses;

import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Mission;
import interfacesAndAbstraction.exercises.militaryElite.interfaces.Commando;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(),
                super.getLastName(),
                super.getId(),
                super.getSalary())).append(System.lineSeparator());

        strBuild.append("Corps: ").append(super.getCorps().name).append(System.lineSeparator());

        strBuild.append("Missions: ").append(System.lineSeparator());
        for (Mission mission : missions) {
            strBuild.append("  ").append(mission.toString()).append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
