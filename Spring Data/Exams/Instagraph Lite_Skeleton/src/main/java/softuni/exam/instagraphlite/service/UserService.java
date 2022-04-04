package softuni.exam.instagraphlite.service;

import java.io.IOException;

public interface UserService {
    String USERS_FILE_PATH = "src/main/resources/files/users.json";

    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;
    String exportUsersWithTheirPosts();
}
