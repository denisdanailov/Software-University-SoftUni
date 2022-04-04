package com.example.gamestore.services.viewservice;

public interface ViewService {
    String ALL_GAMES_COMMAND = "AllGames";
    String DETAIL_GAME_COMMAND = "DetailGame";
    String OWNED_GAMES_COMMAND = "OwnedGames";

    String execute(String commandLine);
}
