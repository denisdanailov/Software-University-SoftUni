package bg.softuni.examprep_springfund.service;

import bg.softuni.examprep_springfund.model.entity.Category;
import bg.softuni.examprep_springfund.model.enums.CategoryEnum;

import java.util.Optional;

public interface CategoryService {
    void init();

    Optional<Category> findByName(CategoryEnum name);
}
