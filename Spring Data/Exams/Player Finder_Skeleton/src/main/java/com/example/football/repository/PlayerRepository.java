package com.example.football.repository;

import com.example.football.models.dto.BestPlayerDTO;
import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    @Query(value = "SELECT new com.example.football.models.dto." +
            "BestPlayerDTO(p.firstName AS firstName, p.lastName AS lastName, p.position AS position, tm.name AS townName, tm.stadiumName AS stadiumName) " +
            "FROM Player AS p JOIN p.stats AS s JOIN p.team AS tm JOIN p.town AS tw " +
            "WHERE p.birthDate > '1995-01-01' AND p.birthDate < '2003-01-01' " +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastName ASC")
    List<BestPlayerDTO> findBestPlayers();
}
