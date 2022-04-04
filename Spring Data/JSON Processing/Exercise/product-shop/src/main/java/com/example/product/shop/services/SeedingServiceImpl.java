package com.example.product.shop.services;

import com.example.product.shop.dtos.seedingDTOs.CategoriesInputDTO;
import com.example.product.shop.dtos.seedingDTOs.ProductInputDTO;
import com.example.product.shop.dtos.seedingDTOs.UserInputDTO;
import com.example.product.shop.entities.Category;
import com.example.product.shop.entities.Product;
import com.example.product.shop.entities.User;
import com.example.product.shop.repositories.CategoryRepository;
import com.example.product.shop.repositories.ProductRepository;
import com.example.product.shop.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedingServiceImpl implements SeedingService {

    private Gson gson;
    private ModelMapper modelMapper;
    private UserRepository userRepo;
    private ProductRepository productRepo;
    private CategoryRepository categoryRepo;

    @Autowired
    public SeedingServiceImpl(UserRepository userRepo, ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.modelMapper = new ModelMapper();
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader jsonFileReader = new FileReader(USERS_PATH_NAME);

        UserInputDTO[] userInputDTOS = gson.fromJson(jsonFileReader, UserInputDTO[].class);

        Arrays.stream(userInputDTOS).forEach(UserInputDTO::validate);

        List<User> userCollection = Arrays.stream(userInputDTOS).map(dto -> modelMapper.map(dto, User.class)).collect(Collectors.toList());

        this.userRepo.saveAll(userCollection);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader jsonFileReader = new FileReader(CATEGORIES_PATH_NAME);

        CategoriesInputDTO[] categoriesInputDTOs = gson.fromJson(jsonFileReader, CategoriesInputDTO[].class);

        Arrays.stream(categoriesInputDTOs).forEach(CategoriesInputDTO::validate);

        List<Category> categoryCollection = Arrays.stream(categoriesInputDTOs).map(dto -> modelMapper.map(dto, Category.class)).collect(Collectors.toList());

        this.categoryRepo.saveAll(categoryCollection);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader jsonFileReader = new FileReader(PRODUCTS_PATH_NAME);

        ProductInputDTO[] productInputDTOs = gson.fromJson(jsonFileReader, ProductInputDTO[].class);

        Arrays.stream(productInputDTOs).forEach(ProductInputDTO::validate);

        List<Product> productCollection = Arrays.stream(productInputDTOs).map(dto -> modelMapper.map(dto, Product.class)).collect(Collectors.toList());

//        Set sellerId, buyerId and categories
        int countProduct = 0;
        for (Product p : productCollection) {
            countProduct++;

            Random rnd = new Random();

            // Set seller
            long countUsers = userRepo.count();
            int randId = rnd.nextInt(1, (int) countUsers + 1);

            Optional<User> optUser = userRepo.findById(randId);
            optUser.ifPresent(p::setSellerId);

            // Set buyer
            if (countProduct % 3 != 0) {
                randId = rnd.nextInt(1, (int) countUsers + 1);

                optUser = userRepo.findById(randId);
                optUser.ifPresent(p::setBuyerId);
            }

            // Set categories
            long countCategories = categoryRepo.count();

            int rndCategories = rnd.nextInt((int) categoryRepo.count());

            Set<Category> categories = rnd.ints(rndCategories, 1, (int) countCategories + 1)
                    .mapToObj(id -> categoryRepo.findById(id))
                    .map(Optional::get)
                    .collect(Collectors.toSet());

            p.setCategories(categories);
        }

        this.productRepo.saveAll(productCollection);
    }
}
