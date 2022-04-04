package com.example.cardealer.services;

import java.io.FileNotFoundException;

public interface SeedingService {
    String SUPPLIERS_FILE_PATH = "src/main/resources/files.cardealer/suppliers.json";

    void seedSuppliers() throws FileNotFoundException;

}
