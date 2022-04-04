package com.example.football;

import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;
    private final PlayerService playerService;

    @Autowired
    public ConsoleRunner(TownService townService, TeamService teamService, StatService statService, PlayerService playerService) {
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
        this.playerService = playerService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

    }

    private void seedDatabase() throws FileNotFoundException, JAXBException {
        this.townService.importTowns();
        this.teamService.importTeams();
        this.statService.importStats();
        this.playerService.importPlayers();
    }
}
