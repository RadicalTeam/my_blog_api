package com.data.postgres.my_blog_api.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterUtil {
    public static Path getNewMDFilePath(String prefixFileName) {
        String pathStr = FileReaderUtil
                .BLOG_FOLDER
                .concat(File.separator)
                .concat(prefixFileName)
                .concat(".md");
        return Paths.get(pathStr);
    }

    public static Path getNewHTMLFilePath(String prefixFileName) {
        String pathStr = FileReaderUtil
                .BLOG_FOLDER
                .concat(File.separator)
                .concat(prefixFileName)
                .concat(".html");
        return Paths.get(pathStr);
    }


    public static void updateMDFile(String location, String content) throws IOException {
        Files.write(Paths.get(location + ".md"), content.getBytes());
    }

}
