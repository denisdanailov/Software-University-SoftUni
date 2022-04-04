package com.example.gamestore.services.gameservice;

import com.example.gamestore.entities.Game;
import com.example.gamestore.entities.dto.AddGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class GameExecuteServiceImpl implements GameExecuteService {

    private GameService gameService;

    @Autowired
    public GameExecuteServiceImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(String commandLine) {
        String[] inputArr = commandLine.split("\\|");

        String command = inputArr[0];
        int id;
        switch (command) {
            case ADD_GAME_COMMAND:
                String title = inputArr[1];
                BigDecimal price = new BigDecimal(inputArr[2]);
                float size = Float.parseFloat(inputArr[3]);
                String trailer = inputArr[4];
                String thumbnail = inputArr[5];
                String description = inputArr[6];
                LocalDate releaseDate = LocalDate.parse(inputArr[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                AddGameDTO gameDTO = new AddGameDTO(title, price, size, trailer, thumbnail, description, releaseDate);
                gameDTO.validation();

                Game addedGame = gameService.addGame(gameDTO);


                return String.format("Added %s", addedGame.getTitle());

            case EDIT_GAME_COMMAND:
                id = Integer.parseInt(inputArr[1]);
                List<String> values = Arrays.stream(inputArr).skip(2).map(String::valueOf).toList();

                Game editedGame = gameService.editGame(id, values);

                if (editedGame != null) {
                    return String.format("Edited %s", editedGame.getTitle());
                }

                return String.format("There is no game with id %d in the catalog.",id);

            case DELETE_GAME_COMMAND:
                id = Integer.parseInt(inputArr[1]);

                Game gameToDelete = gameService.findGameById(id);

                if (gameToDelete != null) {
                    gameService.delete(gameToDelete);
                    return String.format("Deleted %s", gameToDelete.getTitle());
                }

                return String.format("There is no game with id %d in the catalog.",id);

            case PURCHASE_GAME_COMMAND:
                int gameId = Integer.parseInt(inputArr[1]);

                Game boughtGame = gameService.purchaseGame(gameId);

                if (boughtGame == null) {
                    return String.format("Either game with id %d doesn't exist, or no user is currently logged in.", gameId);
                }

                return String.format("%s successfully purchased.", boughtGame.getTitle());

            default:
                return String.format("No such command supported: %s", command);
        }

    }
}
