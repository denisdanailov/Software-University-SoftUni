package softuni.exam.util;

import java.io.File;
import java.io.IOException;

public interface FileUtil {
    String readFile(String filePath) throws IOException;

    File createFile(String path);
}
