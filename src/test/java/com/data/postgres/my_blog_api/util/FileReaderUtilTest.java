package com.data.postgres.my_blog_api.util;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test_Map_function() throws Exception {
        Map<String, String> sd = new HashMap<>();
        System.out.println("id: " + sd.get("id"));
    }
}