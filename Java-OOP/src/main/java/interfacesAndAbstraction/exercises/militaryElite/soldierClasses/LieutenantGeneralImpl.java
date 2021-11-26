package interfacesAndAbstraction.exercises.militaryElite.soldierClasses;

import interfacesAndAbstraction.exercises.militaryElite.interfaces.LieutenantGeneral;
import interfacesAndAbstraction.exercises.militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Private> subordinates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.subordinates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.subordinates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(),
                super.getLastName(),
                super.getId(),
                super.getSalary())).append(System.lineSeparator());

        strBuild.append("Privates:").append(System.lineSeparator());

        Collections.sort(subordinates,(a, b) -> Integer.compare(b.getId(), a.getId()));

        for (int i = 0; i < subordinates.size(); i++) {
            strBuild.append("  ").append(subordinates.get(i)).append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
