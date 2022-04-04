package com.example.product.shop.services;

import com.example.product.shop.dtos.query3.CategoryByProductCountDTO;
import com.example.product.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryByProductCountDTO> getAllByProductCount() {

        return this.categoryRepo.findAllByProductsCount();
    }
}
