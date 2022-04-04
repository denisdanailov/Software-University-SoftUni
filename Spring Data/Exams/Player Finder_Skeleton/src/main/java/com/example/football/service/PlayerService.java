package com.example.football.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface PlayerService {
    String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
    boolean areImported();

    String readPlayersFileContent() throws IOException;

    String importPlayers() throws JAXBException;

    String exportBestPlayers();
}
