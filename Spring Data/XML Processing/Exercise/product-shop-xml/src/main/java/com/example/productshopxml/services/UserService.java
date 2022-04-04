package com.example.productshopxml.services;

import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSaleDTO;
import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSalesFactory;
import com.example.productshopxml.dtos.userDTOs.UsersExportFactory;

import java.util.List;

public interface UserService {

    List<UserSuccessfulSaleDTO> getUsersWithSuccessfulSalesOrderByLastName();

    UsersExportFactory getUsersWithSuccessfulSaleOrderByProductsCount();
}
