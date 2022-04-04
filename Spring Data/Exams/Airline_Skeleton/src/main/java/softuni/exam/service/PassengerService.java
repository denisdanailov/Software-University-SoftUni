package softuni.exam.service;

import java.io.IOException;

public interface PassengerService {
    String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

	String getPassengersOrderByTicketsCountDescendingThenByEmail();
}
