package com.example.product.shop.services;

import com.example.product.shop.dtos.query1.ProductOutputDTO;
import com.example.product.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductOutputDTO> getAllByPriceBetweenAndNoBuyer(double from, double to) {
        BigDecimal lowerBound = new BigDecimal(from);
        BigDecimal upperBound = new BigDecimal(to);

        return this.productRepo.findAllByPriceBetweenBuyerIdIsNUllOrderByPrice(lowerBound, upperBound);
    }
}
