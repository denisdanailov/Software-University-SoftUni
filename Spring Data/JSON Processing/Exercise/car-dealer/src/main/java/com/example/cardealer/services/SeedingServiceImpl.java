package com.example.cardealer.services;

import com.example.cardealer.SupplierRepository;
import com.example.cardealer.entities.Supplier;
import com.example.cardealer.dtos.SuppliersInputDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeedingServiceImpl implements SeedingService {

    private Gson gson;
    private ModelMapper modelMapper;
    private SupplierRepository supplierRepo;

    public SeedingServiceImpl(SupplierRepository supplierRepo) {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.modelMapper = new ModelMapper();
        this.supplierRepo = supplierRepo;
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException {

        FileReader fileReader = new FileReader(SUPPLIERS_FILE_PATH);

        SuppliersInputDTO[] suppliersInputDTOs = this.gson.fromJson(fileReader, SuppliersInputDTO[].class);

        List<Supplier> suppliersList = Arrays.stream(suppliersInputDTOs).map(dto -> modelMapper.map(dto, Supplier.class)).collect(Collectors.toList());

        this.supplierRepo.saveAll(suppliersList);
    }
}
