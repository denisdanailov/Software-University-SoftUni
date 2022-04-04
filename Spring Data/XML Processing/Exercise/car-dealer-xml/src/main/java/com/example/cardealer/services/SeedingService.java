package com.example.cardealer.services;

import javax.xml.bind.JAXBException;

public interface SeedingService {
    String SUPPLIERS_FILE_PATH = "src/main/resources/files.input/suppliers.xml";
    String PARTS_PATH_FILE = "src/main/resources/files.input/parts.xml";
    String CARS_FILE_PATH = "src/main/resources/files.input/cars.xml";
    String CUSTOMERS_FILE_PATH = "src/main/resources/files.input/customers.xml";

    void seedSuppliers() throws JAXBException;

    void seedParts() throws JAXBException;

    void seedCars() throws JAXBException;

    void seedCustomers() throws JAXBException;

    void seedSales();

    default void seedAll() throws JAXBException {
     seedSuppliers();
     seedParts();
     seedCars();
     seedCustomers();
     seedSales();
    }
}
