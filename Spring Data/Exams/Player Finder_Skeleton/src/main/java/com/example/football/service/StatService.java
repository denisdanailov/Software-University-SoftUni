package com.example.football.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface StatService {
    String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    boolean areImported();

    String readStatsFileContent() throws IOException;

    String importStats() throws JAXBException;

}
