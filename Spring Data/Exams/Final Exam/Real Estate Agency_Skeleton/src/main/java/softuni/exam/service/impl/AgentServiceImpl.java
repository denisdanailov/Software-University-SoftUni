package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.agentDTOs.CreateAgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepo;
    private final TownRepository townRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepo, TownRepository townRepo, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, FileUtil fileUtil) {
        this.agentRepo = agentRepo;
        this.townRepo = townRepo;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
    }

    @Override
    public boolean areImported() {
        return this.agentRepo.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return fileUtil.readFile(AGENTS_FILE_PATH);
    }

    @Override
    public String importAgents() throws IOException {

        CreateAgentDTO[] createAgentDTOs = gson.fromJson(this.readAgentsFromFile(), CreateAgentDTO[].class);

        Set<Agent> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateAgentDTO dto : createAgentDTOs) {
            if (!this.validationUtil.isValid(dto)) {
                sb.append("Invalid agent").append(System.lineSeparator());
                continue;
            }

            Optional<Agent> optAgent = this.agentRepo.findByFirstNameOrEmail(dto.getFirstName(), dto.getEmail());
            if (optAgent.isPresent()) {
                sb.append("Invalid agent").append(System.lineSeparator());
                continue;
            }

            Optional<Town> optTown = this.townRepo.findByTownName(dto.getTown());
            if (optTown.isEmpty()) {
                sb.append("Invalid agent").append(System.lineSeparator());
                continue;
            }

            Agent agent = this.modelMapper.map(dto, Agent.class);

            agent.setTown(optTown.get());

            if (toImport.add(agent)) {
                sb.append(String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName()))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid agent").append(System.lineSeparator());
            }

        }

        this.agentRepo.saveAll(toImport);

        return sb.toString();
    }
}
