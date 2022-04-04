package com.example.football.service.impl;

import com.example.football.models.dto.BestPlayerDTO;
import com.example.football.models.dto.xml.*;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepo;
    private final TownRepository townRepo;
    private final TeamRepository teamRepo;
    private final StatRepository statRepo;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepo, TownRepository townRepo, TeamRepository teamRepo,
                             StatRepository statRepo, ModelMapper modelMapper, Validator validator) {
        this.playerRepo = playerRepo;
        this.townRepo = townRepo;
        this.teamRepo = teamRepo;
        this.statRepo = statRepo;

        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.playerRepo.count() > 1;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        Path filePath = Path.of(PLAYERS_FILE_PATH);
        return Files.readString(filePath);
    }

    @Override
    public String importPlayers() throws JAXBException {
        File playerFile = new File(PLAYERS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreatePlayersFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreatePlayersFactory createPlayersFactory = (CreatePlayersFactory) unmarshaller.unmarshal(playerFile);

        List<CreatePlayerDTO> players = createPlayersFactory.getPlayers();

        StringBuilder sb = new StringBuilder();
        List<Player> toImport = new ArrayList<>();

        for (CreatePlayerDTO playerDTO : players) {

//            if (!playerDTO.validate()) {
//               sb.append("Invalid Player").append(System.lineSeparator());
//               continue;
//            }

            Set<ConstraintViolation<CreatePlayerDTO>> errorSet = validator.validate(playerDTO);
            if (!errorSet.isEmpty()) {
                sb.append("Invalid Player").append(System.lineSeparator());
                continue;
            }

            Optional<Player> playerOtp = this.playerRepo.findByEmail(playerDTO.getEmail());
            if (playerOtp.isPresent()) {
                sb.append("Invalid Player").append(System.lineSeparator());
                continue;
            }

            modelMapper.addConverter(new Converter<String, LocalDate>() {
                @Override
                public LocalDate convert(MappingContext<String, LocalDate> context) {
                    String dateString = context.getSource();
                    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }
            });

            Player player = this.modelMapper.map(playerDTO, Player.class);

//            Set Birth Date manually without a Converter in the Model Mapper
//            LocalDate birthDate = LocalDate.parse(playerDTO.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//            player.setBirthDate(birthDate);

            Town town = this.townRepo.findByName(playerDTO.getTown().getName()).get();
            player.setTown(town);

            Team team = this.teamRepo.findByName(playerDTO.getTeam().getName()).get();
            player.setTeam(team);

            Stat stat = this.statRepo.findById(playerDTO.getStat().getId()).get();
            player.setStats(stat);

            toImport.add(player);

            sb.append("Successfully imported Player ").append(player).append(System.lineSeparator());
        }

        this.playerRepo.saveAll(toImport);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        List<BestPlayerDTO> bestPlayersDTOs = this.playerRepo.findBestPlayers();

        StringBuilder sb = new StringBuilder();

        bestPlayersDTOs.stream().forEach(p -> sb.append(String.format("Player - %s %s\n" +
                        "\tPosition - %s\n" +
                        "\tTeam - %s\n" +
                        "\tStadium - %s\n", p.getFirstName(), p.getLastName(),
                p.getPosition().toString(), p.getTeamName(), p.getStadiumName())).append(System.lineSeparator()));

        return sb.toString();
    }
}
