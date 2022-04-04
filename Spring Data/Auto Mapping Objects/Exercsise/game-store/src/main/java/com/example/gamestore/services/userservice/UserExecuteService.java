package com.example.gamestore.services.userservice;

public interface UserExecuteService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT_USER_COMMAND = "Logout";

    String execute(String commandLine);
}
