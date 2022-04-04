package softuni.exam.service;


import java.io.IOException;

public interface PictureService {
    String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";

    boolean areImported();

    String readPicturesFromFile() throws IOException;
	
	String importPictures() throws IOException;

}
