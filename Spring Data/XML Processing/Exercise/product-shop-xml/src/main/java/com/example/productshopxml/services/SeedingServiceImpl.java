package com.example.productshopxml.services;

import com.example.productshopxml.dtos.categoryDTOs.CreateCategoriesFactory;
import com.example.productshopxml.dtos.productDTOs.CreateProductsFactory;
import com.example.productshopxml.dtos.userDTOs.CreateUsersFactory;
import com.example.productshopxml.entities.Category;
import com.example.productshopxml.entities.Product;
import com.example.productshopxml.entities.User;
import com.example.productshopxml.repositories.CategoryRepository;
import com.example.productshopxml.repositories.ProductRepository;
import com.example.productshopxml.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedingServiceImpl implements SeedingService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    @Autowired
    public SeedingServiceImpl(CategoryRepository categoryRepo, UserRepository userRepo, ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void seedCategories() throws JAXBException {
        File categoriesFile = new File(CATEGORIES_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateCategoriesFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateCategoriesFactory catgFactory =(CreateCategoriesFactory) unmarshaller.unmarshal(categoriesFile);

        List<Category> categoriesList = catgFactory.getListCategories()
                .stream()
                .map(dto -> modelMapper.map(dto, Category.class))
                .collect(Collectors.toList());

        this.categoryRepo.saveAll(categoriesList);
    }

    @Override
    public void seedUsers() throws JAXBException {
        File usersFile = new File(USERS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateUsersFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateUsersFactory usersFactory = (CreateUsersFactory) unmarshaller.unmarshal(usersFile);

        List<User> usersList = usersFactory.getUsers()
                .stream()
                .map(dto -> modelMapper.map(dto, User.class))
                .collect(Collectors.toList());

        this.userRepo.saveAll(usersList);

    }

    @Override
    public void seedProducts() throws JAXBException {
        File productsFile = new File(PRODUCTS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateProductsFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateProductsFactory productsFactory = (CreateProductsFactory) unmarshaller.unmarshal(productsFile);

        List<Product> productList = productsFactory.getProducts()
                .stream()
                .map(dto -> modelMapper.map(dto, Product.class))
                .collect(Collectors.toList());

        int countProduct = 0;
        for (Product product : productList) {
            countProduct++;

            Random rnd = new Random();

            // Set seller
            long countUsers = userRepo.count();
            int randId = rnd.nextInt(1, (int) countUsers + 1);

            Optional<User> optUser = userRepo.findById(randId);
            optUser.ifPresent(product::setSellerId);

            // Set buyer
            if (countProduct % 3 != 0) {
                randId = rnd.nextInt(1, (int) countUsers + 1);

                optUser = userRepo.findById(randId);
                optUser.ifPresent(product::setBuyerId);
            }

            // Set categories
            long countCategories = categoryRepo.count();

            int rndCategories = rnd.nextInt((int) categoryRepo.count());

            Set<Category> categories = rnd.ints(rndCategories, 1, (int) countCategories + 1)
                    .mapToObj(categoryRepo::findById)
                    .map(Optional::get)
                    .collect(Collectors.toSet());

            product.setCategories(categories);
        }

        this.productRepo.saveAll(productList);
    }

    @Override
    public void seedAll() {

    }
}
