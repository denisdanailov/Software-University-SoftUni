package com.example.productshopxml.repositories;

import com.example.productshopxml.dtos.categoryDTOs.CategoryExportDTO;
import com.example.productshopxml.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT new com.example.productshopxml.dtos.categoryDTOs.CategoryExportDTO(c.name, COUNT(p.id), AVG(p.price), SUM(p.price)) " +
            "FROM Category AS c JOIN c.products AS p " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(p.id)")
    List<CategoryExportDTO> findAllCategoriesByProducts();
}
