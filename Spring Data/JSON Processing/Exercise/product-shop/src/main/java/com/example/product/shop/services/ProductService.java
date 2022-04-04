package com.example.product.shop.services;

import com.example.product.shop.dtos.query1.ProductOutputDTO;

import java.util.List;

public interface ProductService {

    List<ProductOutputDTO> getAllByPriceBetweenAndNoBuyer(double from, double to);
}
