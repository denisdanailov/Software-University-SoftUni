package com.example.product.shop.services;

import com.example.product.shop.dtos.query3.CategoryByProductCountDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryByProductCountDTO> getAllByProductCount();
}
