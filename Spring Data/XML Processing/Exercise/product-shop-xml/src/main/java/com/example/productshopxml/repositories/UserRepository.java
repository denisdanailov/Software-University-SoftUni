package com.example.productshopxml.repositories;

import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSaleDTO;
import com.example.productshopxml.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "FROM User As u JOIN u.sellingItems AS p " +
            "WHERE p.buyerId IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY u.lastName ASC, u.firstName ASC")
    List<User> findAllBySuccessfulSaleOrderByLastName();

    @Query(value = "FROM User AS u JOIN u.sellingItems AS p " +
            "WHERE p.buyerId IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY COUNT(p.id) DESC, u.lastName ASC")
    List<User> findAllWithSuccessfulSaleOrderByProductsSold();
}
