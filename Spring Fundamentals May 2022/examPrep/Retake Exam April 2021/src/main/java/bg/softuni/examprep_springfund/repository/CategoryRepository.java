package bg.softuni.examprep_springfund.repository;

import bg.softuni.examprep_springfund.model.entity.Category;
import bg.softuni.examprep_springfund.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryEnum category);
}
