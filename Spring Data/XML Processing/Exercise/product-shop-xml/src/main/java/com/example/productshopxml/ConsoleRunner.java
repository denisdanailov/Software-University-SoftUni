package com.example.productshopxml;

import com.example.productshopxml.dtos.categoryDTOs.CategoriesExportFactory;
import com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO;
import com.example.productshopxml.dtos.productDTOs.ProductsOutputDTO;
import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSaleDTO;
import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSalesFactory;
import com.example.productshopxml.dtos.userDTOs.UsersExportFactory;
import com.example.productshopxml.services.CategoryService;
import com.example.productshopxml.services.ProductService;
import com.example.productshopxml.services.SeedingService;
import com.example.productshopxml.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedingService seedingService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(SeedingService seedingService, ProductService productService, UserService userService,
                         CategoryService categoryService) {
        this.seedingService = seedingService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

//        _01_SeedDataBase();

//        _02_Q1ProductsInRange();

//        _03_Q2SuccessfullySoldProducts();

//        _03_Q3CategoriesByProductsCount();

//        _03_Q4UsersAndProducts();
    }

    private void _03_Q4UsersAndProducts() throws JAXBException {
        UsersExportFactory usersExportFactory = this.userService.getUsersWithSuccessfulSaleOrderByProductsCount();

        JAXBContext jaxbContext = JAXBContext.newInstance(UsersExportFactory.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(usersExportFactory, System.out);
    }

    private void _03_Q3CategoriesByProductsCount() throws JAXBException {
        CategoriesExportFactory categoriesDTO = this.categoryService.getAllCategoriesByPrice();

        JAXBContext jaxbContext = JAXBContext.newInstance(CategoriesExportFactory.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(categoriesDTO, System.out);
    }

    private void _03_Q2SuccessfullySoldProducts() throws JAXBException {
        List<UserSuccessfulSaleDTO> usersWithSuccessfulSales = this.userService.getUsersWithSuccessfulSalesOrderByLastName();

        UserSuccessfulSalesFactory userFactory = new UserSuccessfulSalesFactory(usersWithSuccessfulSales);

        JAXBContext jaxbContext = JAXBContext.newInstance(UserSuccessfulSalesFactory.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(userFactory, System.out);
    }

    private void _02_Q1ProductsInRange() throws JAXBException {
        List<ProductNamePriceSellerNameDTO> allByBuyerIdIsNull = this.productService.getAllByBuyerIdIsNull();

        ProductsOutputDTO productsOutputDTO = new ProductsOutputDTO(allByBuyerIdIsNull);

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsOutputDTO.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(productsOutputDTO, System.out);
    }

    private void _01_SeedDataBase() throws JAXBException {
        seedingService.seedAll();
    }
}
