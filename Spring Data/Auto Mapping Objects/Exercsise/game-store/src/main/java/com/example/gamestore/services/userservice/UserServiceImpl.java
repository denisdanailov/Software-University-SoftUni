package com.example.gamestore.services.userservice;

import com.example.gamestore.entities.User;
import com.example.gamestore.entities.dto.LoginUserDTO;
import com.example.gamestore.entities.dto.RegisterUserDTO;
import com.example.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private User currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.currentUser = null;
    }

    @Override
    public User register(RegisterUserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User toRegister = modelMapper.map(userDTO, User.class);

        if (userRepo.count() == 0) {
            toRegister.setIsAdmin(true);
        }

        return userRepo.save(toRegister);
    }

    @Override
    public User login(LoginUserDTO loginDTO) {

        User user = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        if (user != null) {
            this.currentUser = user;
        }

        return user;
    }

    @Override
    public void logout() {

        if (currentUser != null) {
            currentUser = null;
        }
    }

    @Override
    public User getLoggedInUser() {
        return this.currentUser;
    }
}
