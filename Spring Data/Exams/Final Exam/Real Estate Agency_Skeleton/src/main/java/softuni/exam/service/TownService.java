package softuni.exam.service;

import java.io.IOException;

public interface TownService {
    String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;
}
