package com.example.gamestore.services.gameservice;

import com.example.gamestore.entities.Game;
import com.example.gamestore.entities.dto.AddGameDTO;
import com.example.gamestore.entities.dto.views.AllGamesView;
import com.example.gamestore.entities.dto.views.DetailGameView;
import com.example.gamestore.entities.dto.views.OwnedGamesView;

import java.util.List;

public interface GameService {
    String PRICE_PROPERTY = "price";
    String SIZE_PROPERTY = "size";
    String TITLE_PROPERTY = "title";
    String TRAILER_PROPERTY = "trailer";
    String THUMBNAIL_PROPERTY = "thumbnail";
    String DESCRIPTION_PROPERTY = "description";
    String RELEASE_DATE_PROPERTY = "releaseDate";


    Game addGame(AddGameDTO addgameDTO);

    Game editGame(int id, List<String> values);

    Game findGameById(int id);

    void delete(Game entity);

    Game purchaseGame(int gameId);

    List<AllGamesView> getTitleAndPriceForAllGames();

    List<DetailGameView> getDetailsForGameByTitle(String title);

    List<OwnedGamesView> getOwnedGamesTitles(int userID);
}
