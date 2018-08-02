package com.data.postgres.postgres_data.util;

import java.io.File;
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


}
