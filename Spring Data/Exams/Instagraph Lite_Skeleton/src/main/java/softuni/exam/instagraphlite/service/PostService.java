package softuni.exam.instagraphlite.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface PostService {
    String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPosts() throws IOException, JAXBException;

}
