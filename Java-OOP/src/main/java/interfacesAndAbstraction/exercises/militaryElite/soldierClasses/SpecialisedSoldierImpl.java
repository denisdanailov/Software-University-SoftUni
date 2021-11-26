package interfacesAndAbstraction.exercises.militaryElite.soldierClasses;

import interfacesAndAbstraction.exercises.militaryElite.enums.Corps;
import interfacesAndAbstraction.exercises.militaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl (int id, String firstName, String lastName, double salary, String corps) {
        super(id,firstName, lastName, salary);
        this.corps = Corps.valueOf(corps.toUpperCase());
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }
}
