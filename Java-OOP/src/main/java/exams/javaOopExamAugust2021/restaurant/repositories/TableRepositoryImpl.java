package exams.javaOopExamAugust2021.restaurant.repositories;

import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.entities.tables.interfaces.Table;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableRepositoryImpl  implements TableRepository<Table> {
    private List<Table> entities;

    public TableRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableList(entities);
    }

    @Override
    public void add(Table entity) {
        entities.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        for (Table entity : entities) {
            if (entity.getTableNumber() == number) {
                return entity;
            }
        }
        return null;
    }
}
