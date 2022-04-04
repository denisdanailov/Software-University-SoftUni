package spring_data_intro_exercises.services;

import spring_data_intro_exercises.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
