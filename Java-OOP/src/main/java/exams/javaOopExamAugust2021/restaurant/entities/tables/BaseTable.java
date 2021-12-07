package exams.javaOopExamAugust2021.restaurant.entities.tables;

import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static exams.javaOopExamAugust2021.restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static exams.javaOopExamAugust2021.restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFood;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.pricePerPerson = pricePerPerson;
        setSize(size);
        healthyFood = new ArrayList<>();
        beverages = new ArrayList<>();
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        isReservedTable = true;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumFood = healthyFood.stream().map(HealthyFood::getPrice).mapToDouble(e -> e).sum();
        double sumDrinks = beverages.stream().map(Beverages::getPrice).mapToDouble(e -> e).sum();
        double totalSum = sumFood + sumDrinks;
        allPeople = pricePerPerson * numberOfPeople;
        return totalSum + allPeople;
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        numberOfPeople = 0;
        isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format("Table - %d", number)).append(System.lineSeparator());
        strBuild.append(String.format("Size - %d", size)).append(System.lineSeparator());
        strBuild.append(String.format("Type - %s", getClass().getSimpleName())).append(System.lineSeparator());
        strBuild.append(String.format("All price - %f", pricePerPerson));
        return strBuild.toString().trim();
    }
}
