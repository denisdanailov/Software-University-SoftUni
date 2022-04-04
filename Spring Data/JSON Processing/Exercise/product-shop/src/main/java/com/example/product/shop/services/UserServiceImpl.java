package com.example.product.shop.services;

import com.example.product.shop.dtos.query2.SellerUserDTO;
import com.example.product.shop.entities.User;
import com.example.product.shop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
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
    public List<SellerUserDTO> getAllUsersWithSoldItems() {
        List<User> usersList = userRepo.findAllWithSuccessfulSaleOrderLastName();

        return usersList.stream().map(u -> modelMapper.map(u, SellerUserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public long getCountOfUsersWithSuccessfulSales() {
        List<User> userList = userRepo.findAllWithSuccessfulSaleOrderByProductsSold();
        return 0;
    }
}
