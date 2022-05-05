package bg.softuni.examprep_springfund.repository;

import bg.softuni.examprep_springfund.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("FROM User ORDER BY orders.size DESC")
    List<User> findAllOrderedByOrdersCount();

    Optional<User> findByUsernameAndEmail(String username, String email);
}
