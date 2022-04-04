package com.example.cardealer.repositories;

import com.example.cardealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
