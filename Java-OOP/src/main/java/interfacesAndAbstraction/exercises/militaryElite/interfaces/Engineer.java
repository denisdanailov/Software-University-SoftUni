package interfacesAndAbstraction.exercises.militaryElite.interfaces;

import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Repair;

import java.util.List;

public interface Engineer extends SpecialisedSoldier{

    void addRepair(Repair repair);
    List<Repair> getRepairs();
}
