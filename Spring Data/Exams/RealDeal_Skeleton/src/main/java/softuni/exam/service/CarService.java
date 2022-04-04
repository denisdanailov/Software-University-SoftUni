package softuni.exam.service;

import java.io.IOException;

public interface CarService {
    String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();
}
