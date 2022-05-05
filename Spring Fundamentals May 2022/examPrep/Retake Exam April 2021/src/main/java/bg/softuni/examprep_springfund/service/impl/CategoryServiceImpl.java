package bg.softuni.examprep_springfund.service.impl;

import bg.softuni.examprep_springfund.model.entity.Category;
import bg.softuni.examprep_springfund.model.enums.CategoryEnum;
import bg.softuni.examprep_springfund.repository.CategoryRepository;
import bg.softuni.examprep_springfund.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void init() {
        if (categoryRepo.count() > 0) {
            return;
        }

        CategoryEnum[] values = CategoryEnum.values();

        Arrays.stream(values).forEach(this::createAndSaveCategory);
    }

    @Override
    public Optional<Category> findByName(CategoryEnum name) {
        return this.categoryRepo.findByName(name);
    }

    private void createAndSaveCategory(CategoryEnum value) {
        Category category = new Category();

        category.setName(value);

        switch (value) {
            case DRINK -> category.setNeededTime(1);
            case COFFEE -> category.setNeededTime(2);
            case OTHER -> category.setNeededTime(5);
            case CAKE -> category.setNeededTime(10);
        }

        categoryRepo.save(category);
    }
}
