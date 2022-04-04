package com.example.product.shop.services;

import java.io.FileNotFoundException;

public interface SeedingService {
    final static String USERS_PATH_NAME = "src/main/resources/files.productshop/users.json";
    final static String PRODUCTS_PATH_NAME = "src/main/resources/files.productshop/products.json";
    final static String CATEGORIES_PATH_NAME = "src/main/resources/files.productshop/categories.json";

    void seedUsers() throws FileNotFoundException;

    void seedProducts() throws FileNotFoundException;

    void seedCategories() throws FileNotFoundException;

    default void seedAll() throws FileNotFoundException {
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();
    }
}
