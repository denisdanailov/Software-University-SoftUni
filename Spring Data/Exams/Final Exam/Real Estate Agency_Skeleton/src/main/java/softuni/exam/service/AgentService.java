package softuni.exam.service;


import java.io.IOException;

public interface AgentService {
    String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    boolean areImported();

    String readAgentsFromFile() throws IOException;
	
	String importAgents() throws IOException;
}
