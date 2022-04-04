package com.example.football.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TeamService {
    String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    boolean areImported();

    String readTeamsFileContent() throws IOException;

    String importTeams() throws FileNotFoundException;

}
