package com.example.productshopxml.services;

import com.example.productshopxml.dtos.categoryDTOs.CategoriesExportFactory;

import java.util.List;

public interface CategoryService {

    CategoriesExportFactory getAllCategoriesByPrice();
}
