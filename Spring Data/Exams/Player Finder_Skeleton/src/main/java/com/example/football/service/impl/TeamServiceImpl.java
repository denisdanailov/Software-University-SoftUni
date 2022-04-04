package com.example.football.service.impl;

import com.example.football.models.dto.json.CreateTeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//ToDo - Implement all methods
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepo;
    private final TownRepository townRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepo, TownRepository townRepo,
                           @Qualifier(value = "gsonRead") Gson gson, ModelMapper modelMapper, Validator validator) {
        this.teamRepo = teamRepo;
        this.townRepo = townRepo;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.teamRepo.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        Path teamsFilePath = Path.of(TEAMS_FILE_PATH);

        return Files.readString(teamsFilePath);
    }

    @Override
    public String importTeams() throws FileNotFoundException {
        FileReader jsonTeamsReader = new FileReader(TEAMS_FILE_PATH);

        CreateTeamDTO[] teamDTOs = gson.fromJson(jsonTeamsReader, CreateTeamDTO[].class);

        StringBuilder sb = new StringBuilder();
        List<Team> toImport = new ArrayList<>();

        for (CreateTeamDTO teamDTO : teamDTOs) {

//            if (!teamDTO.validate()) {
//                sb.append("Invalid Team").append(System.lineSeparator());
//                continue;
//            }

            Set<ConstraintViolation<CreateTeamDTO>> errorSet = this.validator.validate(teamDTO);
            if(!errorSet.isEmpty()) {
                sb.append("Invalid Team").append(System.lineSeparator());
                continue;
            }

            // Check if team already exists in DB
            Optional<Team> teamOpt = this.teamRepo.findByName(teamDTO.getName());
            if (teamOpt.isPresent()) {
                sb.append("Invalid Team").append(System.lineSeparator());
                continue;
            }

            Team team = modelMapper.map(teamDTO, Team.class);

            // Check if Town exists in DB
            Optional<Town> townOpt = this.townRepo.findByName(teamDTO.getTownName());
            if (townOpt.isEmpty()) {
                sb.append("Invalid Team").append(System.lineSeparator());
                continue;
            }

            team.setTown(townOpt.get());

            toImport.add(team);

            sb.append("Successfully imported Team ").append(team).append(System.lineSeparator());
        }

        this.teamRepo.saveAll(toImport);

        return sb.toString();
    }
}
