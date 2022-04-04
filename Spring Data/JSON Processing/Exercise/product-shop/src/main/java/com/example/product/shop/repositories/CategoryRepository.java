package com.example.product.shop.repositories;

import com.example.product.shop.dtos.query3.CategoryByProductCountDTO;
import com.example.product.shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT new com.example.product.shop.dtos.query3.CategoryByProductCountDTO(c.name, COUNT(p) AS countProducts, AVG(p.price), SUM(p.price)) " +
            "FROM Category AS c JOIN c.products AS p GROUP BY c.id ORDER BY countProducts DESC")
    List<CategoryByProductCountDTO> findAllByProductsCount();
}
