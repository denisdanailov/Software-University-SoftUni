package com.example.gamestore.services.viewservice;

import com.example.gamestore.entities.User;
import com.example.gamestore.entities.dto.views.AllGamesView;
import com.example.gamestore.entities.dto.views.DetailGameView;
import com.example.gamestore.entities.dto.views.OwnedGamesView;
import com.example.gamestore.services.gameservice.GameService;
import com.example.gamestore.services.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService{

    private GameService gameService;
    private UserService userService;

    @Autowired
    public ViewServiceImpl(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public String execute(String commandLine) {
        String[] inputArr = commandLine.split("\\|");

        String command = inputArr[0];
        StringBuilder sb;

        switch(command) {
            case ALL_GAMES_COMMAND:
                List<AllGamesView> gamesViews = gameService.getTitleAndPriceForAllGames();

                sb = new StringBuilder();
                for (int i = 0; i < gamesViews.size(); i++) {
                    sb.append(gamesViews.get(i).toString()).append(System.lineSeparator());
                }

                if (sb.isEmpty()) {
                    return "No games in the catalog";
                }

                return sb.toString();

            case DETAIL_GAME_COMMAND:
                String inputTitle = inputArr[1];

                List<DetailGameView> detailsViews = gameService.getDetailsForGameByTitle(inputTitle);

                sb = new StringBuilder();
                for (int i = 0; i < detailsViews.size(); i++) {
                    sb.append(detailsViews.get(i).toString()).append(System.lineSeparator());
                }

                if (sb.isEmpty()) {
                    return "No games in the catalog";
                }

                return sb.toString();

            case OWNED_GAMES_COMMAND:
                User loggedInUser = userService.getLoggedInUser();

                if(loggedInUser == null) {
                    return "No user currently logged in.";
                }

                List<OwnedGamesView> ownedGamesViews = gameService.getOwnedGamesTitles(loggedInUser.getId());

                return null;
            default:
                return String.format("No such command supported: %s", command);
        }
    }
}
