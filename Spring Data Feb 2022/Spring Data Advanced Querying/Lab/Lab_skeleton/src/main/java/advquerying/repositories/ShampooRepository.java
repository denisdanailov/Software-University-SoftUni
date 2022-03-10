package advquerying.repositories;

import advquerying.entities.Ingredient;
import advquerying.entities.Label;
import advquerying.entities.Shampoo;
import advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, Long LabelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query(value = "Select s FROM Shampoo AS s Join s.ingredients AS i WHERE i.name IN :ingredientNames")
    Set<Shampoo> findAllByIngredientsNames(@Param(value = "ingredientNames") List<String> names);

    @Query(value = "Select s FROM Shampoo AS s Join s.ingredients AS i GROUP BY s.id HAVING COUNT(i.id) < :ingredientCount")
    List<Shampoo> findAllByIngredientsLessThan(@Param(value = "ingredientCount") long ingredientCount);
}
