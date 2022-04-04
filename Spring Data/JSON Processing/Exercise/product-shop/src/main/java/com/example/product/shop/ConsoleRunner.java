package com.example.product.shop;

import com.example.product.shop.dtos.query3.CategoryByProductCountDTO;
import com.example.product.shop.dtos.query1.ProductOutputDTO;
import com.example.product.shop.dtos.query2.SellerUserDTO;
import com.example.product.shop.services.CategoryService;
import com.example.product.shop.services.ProductService;
import com.example.product.shop.services.SeedingService;
import com.example.product.shop.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner{

    private SeedingService seedingService;
    private ProductService productService;
    private UserService userService;
    private CategoryService categoryService;
    private Gson gson;

    @Autowired
    public ConsoleRunner(SeedingService seedingService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedingService = seedingService;
        this.productService = productService;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        _02_SeedTheDataBase();

//        _03_Query1ProductsInRange();

//        _03_Query2SuccessfullySoldProducts();

//        _03_Query3CategoriesByProductCount();

//        _03_Query4UsersAndProducts();
    }

    private void _03_Query4UsersAndProducts() {
        //TODO
        this.userService.getCountOfUsersWithSuccessfulSales();
    }

    private void _03_Query3CategoriesByProductCount() {
        List<CategoryByProductCountDTO> categoriesDTOs = this.categoryService.getAllByProductCount();

        String json = this.gson.toJson(categoriesDTOs);

        System.out.println(json);
    }

    private void _03_Query2SuccessfullySoldProducts() {
        List<SellerUserDTO> allUsersWithSoldItems = this.userService.getAllUsersWithSoldItems();

        String json = this.gson.toJson(allUsersWithSoldItems);

        System.out.println(json);
    }

    private void _03_Query1ProductsInRange() {
        List<ProductOutputDTO> dtoList = this.productService.getAllByPriceBetweenAndNoBuyer(500, 1000);

        String json = this.gson.toJson(dtoList);

        System.out.println(json);
    }

    private void _02_SeedTheDataBase() throws FileNotFoundException {
        seedingService.seedAll();
    }
}
