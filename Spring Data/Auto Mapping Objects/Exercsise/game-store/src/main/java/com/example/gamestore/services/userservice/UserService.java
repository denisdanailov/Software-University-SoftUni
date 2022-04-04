package com.example.gamestore.services.userservice;

import com.example.gamestore.entities.User;
import com.example.gamestore.entities.dto.LoginUserDTO;
import com.example.gamestore.entities.dto.RegisterUserDTO;

public interface UserService {

   User register(RegisterUserDTO userDTO);

   User login(LoginUserDTO loginDTO);

   void logout();

   User getLoggedInUser();
}
