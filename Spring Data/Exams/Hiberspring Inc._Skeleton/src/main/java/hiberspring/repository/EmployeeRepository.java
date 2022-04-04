package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByCard(EmployeeCard card);

    @Query(value = "FROM Employee AS e JOIN e.branch AS b JOIN b.products AS p " +
            "GROUP BY e.id " +
            "HAVING COUNT(p.id) > 0 " +
            "ORDER BY CONCAT(e.firstName, ' ', e.lastName) ASC, CHAR_LENGTH(e.position) DESC")
    List<Employee> findAllProductiveEmployees();
}
