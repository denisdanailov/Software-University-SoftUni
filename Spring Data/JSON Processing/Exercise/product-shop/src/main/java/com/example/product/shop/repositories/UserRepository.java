package com.example.product.shop.repositories;

import com.example.product.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "FROM User AS u JOIN u.sellingItems AS p " +
            "WHERE p.buyerId IS NOT NULL " +
            "ORDER BY u.lastName ASC, u.firstName ASC")
    List<User> findAllWithSuccessfulSaleOrderLastName();

    @Query(value = "FROM User AS u JOIN u.sellingItems AS p " +
            "WHERE p.buyerId IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY COUNT(p.id) DESC, u.lastName ASC")
    List<User> findAllWithSuccessfulSaleOrderByProductsSold();
}
