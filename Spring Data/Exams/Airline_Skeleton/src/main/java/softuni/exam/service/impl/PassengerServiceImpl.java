package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Passenger;
import softuni.exam.models.Town;
import softuni.exam.models.dtos.passengerDTOs.CreatePassengerDTO;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepo;
    private final TownRepository townRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepo, TownRepository townRepo, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.passengerRepo = passengerRepo;
        this.townRepo = townRepo;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepo.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        FileReader passengersReader = new FileReader(new File(PASSENGERS_FILE_PATH));

        CreatePassengerDTO[] createPassengerDTOs = gson.fromJson(passengersReader, CreatePassengerDTO[].class);

        Set<Passenger> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreatePassengerDTO dto : createPassengerDTOs) {

            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            Optional<Passenger> passengerOpt = this.passengerRepo.findByEmail(dto.getEmail());
            if (passengerOpt.isPresent()) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            Optional<Town> optTown = this.townRepo.findByName(dto.getTown());
            if (optTown.isEmpty()) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            Passenger passenger = modelMapper.map(dto, Passenger.class);

            passenger.setTown(optTown.get());

            toImport.add(passenger);

            sb.append(String.format("Successfully imported Passenger %s - %s"
                    ,passenger.getLastName()
                    ,passenger.getEmail())).append(System.lineSeparator());
        }

        this.passengerRepo.saveAll(toImport);

        return sb.toString();
    }

    @Override
    @Transactional
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        List<Passenger> passengers = this.passengerRepo.findAllByOrderByTicketsCountDescEmailAcs();

        StringBuilder sb = new StringBuilder();

        passengers
                .forEach(p -> sb.append(p)
                        .append(System.lineSeparator()));

        return sb.toString();
    }
}
