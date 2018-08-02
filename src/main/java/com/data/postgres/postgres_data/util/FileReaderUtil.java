package com.data.postgres.postgres_data.util;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public static final String BLOG_FOLDER = "/appData/blogs";

    public static String readBlogContent(String fileName) throws IOException {
        String fileLocation = BLOG_FOLDER + "/" + fileName;
        File file = new File(fileLocation);
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String readBlogContent(URL location) throws IOException {
        if (location != null) {
            return new String(Files.readAllBytes(Paths.get(location.getFile())));
        }
        return null;
    }

    public static String readBlogByLocation(String location) throws IOException {
        File file = new File(location);
        return new String(Files.readAllBytes(file.toPath()));
    }
}
