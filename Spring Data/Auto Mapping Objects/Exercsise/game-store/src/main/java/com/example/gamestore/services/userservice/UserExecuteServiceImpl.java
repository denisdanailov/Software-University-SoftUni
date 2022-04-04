package com.example.gamestore.services.userservice;

import com.example.gamestore.entities.User;
import com.example.gamestore.entities.dto.LoginUserDTO;
import com.example.gamestore.entities.dto.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExecuteServiceImpl implements UserExecuteService {

    private UserService userService;

    @Autowired
    public UserExecuteServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String commandLine) {
        String[] inputArr = commandLine.split("\\|");

        String command = inputArr[0];

        switch(command) {
            case REGISTER_USER_COMMAND:
                String email = inputArr[1];
                String password = inputArr[2];
                String confirmPass = inputArr[3];
                String fullName = inputArr[4];

                RegisterUserDTO regUserDTO = new RegisterUserDTO(fullName, email, password, confirmPass);
                regUserDTO.validate();

                User registered = this.userService.register(regUserDTO);

                return String.format("%s was registered", fullName);

            case LOGIN_USER_COMMAND:
                String logEmail = inputArr[1];
                String logPass = inputArr[2];

                LoginUserDTO logInUserDTO = new LoginUserDTO(logEmail, logPass);
                logInUserDTO.validate();

                User loggedUser = this.userService.login(logInUserDTO);

                if(loggedUser != null) {
                    return String.format("Successfully logged in %s", loggedUser.getFullName());
                }

                return String.format("User with email %s and password %s doesn't exist.");

            case LOGOUT_USER_COMMAND:

                User loggedOutUser = this.userService.getLoggedInUser();

                this.userService.logout();

                if (loggedOutUser != null) {
                    return String.format("User %s successfully logged out.", loggedOutUser.getFullName());
                }

                return "Cannot log out. No user was logged in.";

            default:
                return "Not a supported command";
        }
    }
}
