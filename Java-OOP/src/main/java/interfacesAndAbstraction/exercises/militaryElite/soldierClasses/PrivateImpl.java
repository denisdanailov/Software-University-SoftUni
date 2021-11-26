package interfacesAndAbstraction.exercises.militaryElite.soldierClasses;

import interfacesAndAbstraction.exercises.militaryElite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String secondName, double salary) {
        super(id,firstName,secondName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(),
                super.getLastName(),
                super.getId(),
                this.getSalary());
    }
}
