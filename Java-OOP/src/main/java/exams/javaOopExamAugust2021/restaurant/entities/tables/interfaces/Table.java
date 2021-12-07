package exams.javaOopExamAugust2021.restaurant.entities.tables.interfaces;

import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;

public interface Table {
    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
