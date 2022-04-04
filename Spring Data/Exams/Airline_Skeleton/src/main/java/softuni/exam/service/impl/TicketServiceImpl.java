package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Passenger;
import softuni.exam.models.Plane;
import softuni.exam.models.Ticket;
import softuni.exam.models.Town;
import softuni.exam.models.dtos.ticketDTOs.CreateTicketDTO;
import softuni.exam.models.dtos.ticketDTOs.TicketsFactoryDTO;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final TownRepository townRepo;
    private final PlaneRepository planeRepo;
    private final PassengerRepository passengerRepo;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepo, TownRepository townRepo, PlaneRepository planeRepo,
                             PassengerRepository passengerRepo, XmlParser xmlParser, ValidationUtil validationUtil,
                             @Qualifier(value = "mapperWithStringToLDTimeConverter")ModelMapper modelMapper) {
        this.ticketRepo = ticketRepo;
        this.townRepo = townRepo;
        this.planeRepo = planeRepo;
        this.passengerRepo = passengerRepo;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepo.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException {
        File ticketsFile = new File(TICKETS_FILE_PATH);

        TicketsFactoryDTO ticketsFactoryDTO = xmlParser.parse(ticketsFile, TicketsFactoryDTO.class);

        List<CreateTicketDTO> ticketDTOs = ticketsFactoryDTO.getTickets();

        Set<Ticket> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateTicketDTO dto : ticketDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Optional<Ticket> optTicket = this.ticketRepo.findBySerialNumber(dto.getSerialNumber());
            if (optTicket.isPresent()) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Optional<Town> optFromTown = this.townRepo.findByName(dto.getFromTown().getName());
            Optional<Town> optToTown = this.townRepo.findByName(dto.getToTown().getName());
            Optional<Passenger> optPassenger = this.passengerRepo.findByEmail(dto.getPassenger().getEmail());
            Optional<Plane> optPlane = this.planeRepo.findByRegisterNumber(dto.getPlane().getRegisterNumber());
            if (optFromTown.isEmpty() || optToTown.isEmpty() || optPassenger.isEmpty() || optPlane.isEmpty()) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Ticket ticket = modelMapper.map(dto, Ticket.class);

            ticket.setFromTown(optFromTown.get());
            ticket.setToTown(optToTown.get());
            ticket.setPassenger(optPassenger.get());
            ticket.setPlane(optPlane.get());

            toImport.add(ticket);

            sb.append(String.format("Successfully imported Ticket %s - %s", ticket.getFromTown().getName(), ticket.getToTown().getName()))
                    .append(System.lineSeparator());
        }

        this.ticketRepo.saveAll(toImport);

        return sb.toString();
    }
}
