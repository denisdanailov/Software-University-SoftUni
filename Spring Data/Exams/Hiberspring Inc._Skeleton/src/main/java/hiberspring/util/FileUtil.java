package hiberspring.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public interface FileUtil {

    String readFile(String filePath) throws IOException;
}
