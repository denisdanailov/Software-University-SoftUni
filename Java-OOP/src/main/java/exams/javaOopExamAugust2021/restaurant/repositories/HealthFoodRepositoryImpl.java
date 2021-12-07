package exams.javaOopExamAugust2021.restaurant.repositories;

import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private List<HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood entity : entities) {
            if (entity.getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableList(entities);
    }

    @Override
    public void add(HealthyFood entity) {
        entities.add(entity);
    }
}
