package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findByEmail(String email);

    @Query(value = "FROM Passenger AS p JOIN p.tickets AS t GROUP BY p.id ORDER BY COUNT(t.id) DESC, p.email Asc")
    List<Passenger> findAllByOrderByTicketsCountDescEmailAcs();
}
