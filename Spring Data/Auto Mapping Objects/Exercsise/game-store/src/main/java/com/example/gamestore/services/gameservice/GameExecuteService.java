package com.example.gamestore.services.gameservice;

public interface GameExecuteService {
    final static String ADD_GAME_COMMAND = "AddGame";
    final static String EDIT_GAME_COMMAND = "EditGame";
    final static String DELETE_GAME_COMMAND = "DeleteGame";
    final static String PURCHASE_GAME_COMMAND = "PurchaseGame";

    String execute(String commandLine);
}
