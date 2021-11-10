package interfacesAndAbstraction.exercises.militaryElite.interfaces;

import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Mission;

import java.util.List;

public interface Commando extends SpecialisedSoldier{

    void addMission(Mission mission);
    List<Mission> getMissions();
}
