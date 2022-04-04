package com.example.productshopxml.services;

import javax.xml.bind.JAXBException;

public interface SeedingService {
    public static final String CATEGORIES_FILE_PATH = "src/main/resources/files/input/categories.xml";
    public static final String USERS_FILE_PATH = "src/main/resources/files/input/users.xml";
    public static final String PRODUCTS_FILE_PATH = "src/main/resources/files/input/products.xml";

    void seedCategories() throws JAXBException;

    void seedUsers() throws JAXBException;

    void seedProducts() throws JAXBException;

    default void seedAll() throws JAXBException {
     seedCategories();
     seedUsers();
     seedProducts();
    }
}
