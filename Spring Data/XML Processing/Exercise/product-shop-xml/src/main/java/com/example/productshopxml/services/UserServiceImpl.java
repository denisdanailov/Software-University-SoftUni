package com.example.productshopxml.services;

import com.example.productshopxml.dtos.userDTOs.UserExportDTO;
import com.example.productshopxml.dtos.userDTOs.UserSuccessfulSaleDTO;
import com.example.productshopxml.dtos.userDTOs.UsersExportFactory;
import com.example.productshopxml.entities.User;
import com.example.productshopxml.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<UserSuccessfulSaleDTO> getUsersWithSuccessfulSalesOrderByLastName() {

        List<User> allBySuccessfulSale = this.userRepo.findAllBySuccessfulSaleOrderByLastName();

        // Exclude products with buyerId == null
        allBySuccessfulSale
                .stream()
                .forEach(u -> u.setSellingItems(u.getSellingItems()
                        .stream()
                        .filter(p -> p.getBuyerId() != null).toList()));

        List<UserSuccessfulSaleDTO> listDTOs = allBySuccessfulSale
                .stream()
                .map(u -> modelMapper.map(u, UserSuccessfulSaleDTO.class))
                .collect(Collectors.toList());

        return listDTOs;
    }

    @Override
    @Transactional
    public UsersExportFactory getUsersWithSuccessfulSaleOrderByProductsCount() {

        List<User> userList = this.userRepo.findAllWithSuccessfulSaleOrderByProductsSold();

        // Exclude products with buyerId == null
        userList.forEach(u -> u.setSellingItems(u.getSellingItems().stream().filter(p -> p.getBuyerId() != null).toList()));

        List<UserExportDTO> userExportDTOList = userList.stream().map(u -> modelMapper.map(u, UserExportDTO.class)).collect(Collectors.toList());

        userExportDTOList.forEach(UserExportDTO::setProductFactoryDTO);

        UsersExportFactory usersExportFactory = new UsersExportFactory(userExportDTOList);

        return usersExportFactory;
    }
}
