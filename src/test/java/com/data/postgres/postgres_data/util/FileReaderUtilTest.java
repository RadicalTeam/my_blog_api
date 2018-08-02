package com.data.postgres.postgres_data.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class FileReaderUtilTest {

    @Test
    public void should_read_file_as_string() throws Exception {
        URL location = FileReaderUtilTest.class.getClassLoader().getResource("test.txt");

        String fileString = FileReaderUtil.readBlogContent(location);
        Assert.assertEquals(fileString, "124");
    }

    @Test
    public void should_read_file_as_string_in_upload_folder() throws Exception {
        String fileString = FileReaderUtil.readBlogContent("test.txt");
        Assert.assertEquals(fileString.trim(), "124");
    }
}