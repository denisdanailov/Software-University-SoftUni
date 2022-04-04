package com.example.product.shop.services;

import com.example.product.shop.dtos.query2.SellerUserDTO;

import java.util.List;

public interface UserService {

    List<SellerUserDTO> getAllUsersWithSoldItems();

    long getCountOfUsersWithSuccessfulSales();
}
