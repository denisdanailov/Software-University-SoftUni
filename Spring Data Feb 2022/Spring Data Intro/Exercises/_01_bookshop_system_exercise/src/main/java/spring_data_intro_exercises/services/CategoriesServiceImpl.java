package spring_data_intro_exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_intro_exercises.entities.Category;
import spring_data_intro_exercises.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoriesServiceImpl implements CategoryService{

    private CategoryRepository categoryRepo;

    @Autowired
    public CategoriesServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Set<Category> getRandomCategories() {
        long count = categoryRepo.count();

        Random rnd = new Random();

        int categoriesCount = rnd.nextInt((int)count) + 1;

        Set<Integer> categories = new HashSet<>();

        for (int i = 0; i < categoriesCount; i++) {
            int nextId = rnd.nextInt((int)count) + 1;
            categories.add(nextId);
        }

        return new HashSet<>(categoryRepo.findAllById(categories));
    }
}
