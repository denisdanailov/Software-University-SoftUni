package advquerying.repositories;

import advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String symbol);

    List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> names);

    @Modifying
    @Transactional
    int deleteByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ingredient AS i SET i.price = i.price * :valParam")
    void increasePriceOfAllBy(@Param(value = "valParam") BigDecimal value);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ingredient AS i SET i.price = i.price * :valParam WHERE i.name IN :nameParams")
    void increasePriceOfAllNameIn(@Param(value = "valParam")BigDecimal value, @Param(value = "nameParams")List<String> names);
}
