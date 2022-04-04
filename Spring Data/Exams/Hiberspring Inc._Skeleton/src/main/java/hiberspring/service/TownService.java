package hiberspring.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TownService {
    String TOWNS_FILE_PATH = "src/main/resources/files/towns.json";

    Boolean townsAreImported();

    String readTownsJsonFile() throws IOException;

    String importTowns(String townsFileContent) ;
}
