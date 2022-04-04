package com.example.product.shop.repositories;

import com.example.product.shop.dtos.query1.ProductOutputDTO;
import com.example.product.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT " +
            " new com.example.product.shop.dtos.query1.ProductOutputDTO(p.name, p.price, p.sellerId.firstName, p.sellerId.lastName) " +
            "FROM Product AS p WHERE p.price BETWEEN :from AND :to AND p.buyerId IS NULL ORDER BY PRICE ASC")
    List<ProductOutputDTO> findAllByPriceBetweenBuyerIdIsNUllOrderByPrice(BigDecimal from, BigDecimal to);

}
