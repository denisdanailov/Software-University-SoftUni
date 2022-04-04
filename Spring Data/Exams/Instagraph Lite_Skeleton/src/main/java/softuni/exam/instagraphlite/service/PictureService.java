package softuni.exam.instagraphlite.service;

import java.io.IOException;

public interface PictureService {
    String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

}
