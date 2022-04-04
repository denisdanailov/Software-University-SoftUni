package com.example.productshopxml.services;

import com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO;

import java.util.List;


public interface ProductService {

    List<ProductNamePriceSellerNameDTO> getAllByBuyerIdIsNull();
}
