package com.example.gamestore.repositories;

import com.example.gamestore.entities.Game;
import com.example.gamestore.entities.dto.views.AllGamesView;
import com.example.gamestore.entities.dto.views.DetailGameView;
import com.example.gamestore.entities.dto.views.OwnedGamesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query(value = "SELECT new com.example.gamestore.entities.dto.views.AllGamesView(g.title, g.price) " +
            "FROM Game AS g ")
    List<AllGamesView> findTitleAndPriceForAll();

    List<DetailGameView> findByTitle(String title);

    //TODO: Add jpql to @Query join user and users_tables
    @Query(value = "SELECT com.example.gamestore.entities.dto.views.OwnedGamesView(g.title) " +
            "FROM User AS u JOIN u.games AS g WHERE u.id = :paramID")
    List<OwnedGamesView> getTitlesOwnedGames(@Param(value = "paramID") int loggedUserId);
}
