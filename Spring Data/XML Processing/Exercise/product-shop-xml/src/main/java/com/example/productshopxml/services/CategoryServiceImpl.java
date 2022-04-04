package com.example.productshopxml.services;

import com.example.productshopxml.dtos.categoryDTOs.CategoriesExportFactory;
import com.example.productshopxml.dtos.categoryDTOs.CategoryExportDTO;
import com.example.productshopxml.repositories.CategoryRepository;
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
    public CategoriesExportFactory getAllCategoriesByPrice() {
        List<CategoryExportDTO> allCategoriesByProducts = this.categoryRepo.findAllCategoriesByProducts();

        CategoriesExportFactory categoriesExportFactory = new CategoriesExportFactory(allCategoriesByProducts);

        return categoriesExportFactory;
    }
}
