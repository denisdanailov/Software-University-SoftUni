package spring_data_intro_exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_data_intro_exercises.entities.Author;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllDistinctByBooksReleaseDateBefore(LocalDate releaseDate);

    List<Author> findAllDistinctByBooksNotNull();
}
