package exams.javaOopExamAugust2021.restaurant.repositories;

import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private List<Beverages> entities;

    public BeverageRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        for (Beverages entity : entities) {
            if (entity.getName().equals(drinkName) && entity.getBrand().equals(drinkBrand)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableList(entities);
    }

    @Override
    public void add(Beverages entity) {
        entities.add(entity);
    }
}
