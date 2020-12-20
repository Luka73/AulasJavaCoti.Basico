package aula03.projeto01.utils;

import java.io.FileWriter;

public class FileUtil {

    public static void write(String content, String path) throws Exception {
        FileWriter file = new FileWriter(path);
        file.write(content);
        file.flush();
        file.close();
    }
}
