package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query(value = "FROM User AS u JOIN u.posts AS p GROUP BY u.id ORDER BY COUNT(p.id) DESC, u.id Asc")
    List<User> findAllByOrderByPostsSizeDescIdDesc();
}
