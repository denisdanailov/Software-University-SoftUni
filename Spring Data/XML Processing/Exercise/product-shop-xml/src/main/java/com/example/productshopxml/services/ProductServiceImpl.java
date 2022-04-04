package com.example.productshopxml.services;

import com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO;
import com.example.productshopxml.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductNamePriceSellerNameDTO> getAllByBuyerIdIsNull() {
        List<ProductNamePriceSellerNameDTO> allByBuyerIdIsNull = this.productRepo.findAllByBuyerIdIsNull();
        return allByBuyerIdIsNull;
    }
}
