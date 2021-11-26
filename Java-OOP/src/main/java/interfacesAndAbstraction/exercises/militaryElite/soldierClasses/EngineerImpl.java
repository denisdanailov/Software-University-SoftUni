package interfacesAndAbstraction.exercises.militaryElite.soldierClasses;

import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Repair;
import interfacesAndAbstraction.exercises.militaryElite.interfaces.Engineer;

import java.util.ArrayList;
import java.util.List;


public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
       this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
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

        strBuild.append("Repairs: ").append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            strBuild.append("  ").append(repair.toString()).append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
