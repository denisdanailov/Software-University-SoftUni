package com.example.productshopxml.repositories;

import com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO;
import com.example.productshopxml.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT new com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO(" +
            "p.name, p.price, u.firstName, u.lastName) " +
            "FROM Product AS p JOIN p.sellerId AS u " +
            "WHERE p.buyerId IS NULL")
    List<ProductNamePriceSellerNameDTO> findAllByBuyerIdIsNull();
}
