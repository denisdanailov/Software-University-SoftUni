package com.example.gamestore.services.gameservice;

import com.example.gamestore.entities.Game;
import com.example.gamestore.entities.User;
import com.example.gamestore.entities.dto.AddGameDTO;
import com.example.gamestore.entities.dto.views.AllGamesView;
import com.example.gamestore.entities.dto.views.DetailGameView;
import com.example.gamestore.entities.dto.views.OwnedGamesView;
import com.example.gamestore.repositories.GameRepository;
import com.example.gamestore.repositories.UserRepository;
import com.example.gamestore.services.userservice.UserService;
import com.example.gamestore.validations.GameValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepo;
    private UserService userService;
    private UserRepository userRepo;

    @Autowired
    public GameServiceImpl(GameRepository gameRepo, UserService userService, UserRepository userRepo) {
        this.gameRepo = gameRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @Override
    public Game addGame(AddGameDTO addgameDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Game gameToAdd = modelMapper.map(addgameDTO, Game.class);

        return gameRepo.save(gameToAdd);
    }

    @Override
    public Game editGame(int id, List<String> values) {

        Optional<Game> game = this.gameRepo.findById(id);

        if (game.isEmpty()) {
            return null;
        }

        for (int i = 0; i < values.size(); i++) {
            String[] valArr = values.get(i).split("\\=");

            String property = valArr[0];
            String value = valArr[1];

            switch (property) {
                case PRICE_PROPERTY:
                    BigDecimal newPrice = new BigDecimal(value);

                    GameValidation.validatePrice(newPrice);

                    game.get().setPrice(newPrice);
                    break;
                case SIZE_PROPERTY:
                    float newSize = Float.parseFloat(value);

                    GameValidation.validateSize(newSize);

                    game.get().setSize(newSize);
                    break;
                case TITLE_PROPERTY:
                    GameValidation.validateTitle(value);

                    game.get().setTitle(value);
                    break;
                case THUMBNAIL_PROPERTY:
                    GameValidation.validateThumbnail(value);

                    game.get().setThumbnail(value);
                    break;
                case TRAILER_PROPERTY:
                    GameValidation.validateTrailer(value);

                    game.get().setTrailer(value);
                    break;
                case DESCRIPTION_PROPERTY:
                    GameValidation.validateDescription(value);

                    game.get().setDescription(value);
                    break;
                case RELEASE_DATE_PROPERTY:
                    LocalDate newDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    game.get().setReleaseDate(newDate);
                    break;
            }
        }

        Game updatedGame = this.gameRepo.save(game.get());

        return updatedGame;
    }

    @Override
    public void delete(Game entity) {
        gameRepo.delete(entity);
    }

    @Override
    public Game findGameById(int id) {
        Optional<Game> gameOpt = gameRepo.findById(id);

        return gameOpt.orElse(null);

    }

    @Override
    public List<AllGamesView> getTitleAndPriceForAllGames() {

        return gameRepo.findTitleAndPriceForAll();
    }

    @Override
    public List<DetailGameView> getDetailsForGameByTitle(String title) {

        return gameRepo.findByTitle(title);
    }

    @Override
    public List<OwnedGamesView> getOwnedGamesTitles(int userId) {
        List<OwnedGamesView> titlesOwnedGames = gameRepo.getTitlesOwnedGames(userId);
        return titlesOwnedGames;
    }

    @Override
    public Game purchaseGame(int gameId) {
        Optional<Game> optGame = gameRepo.findById(gameId);

        User currentUser = userService.getLoggedInUser();

        if (optGame.isEmpty() || currentUser == null) {
            return null;
        }

        currentUser.addGame(optGame.get());

        userRepo.save(currentUser);

        return optGame.get();
    }
}

