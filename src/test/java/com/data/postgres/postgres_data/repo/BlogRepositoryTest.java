package com.data.postgres.postgres_data.repo;

import com.data.postgres.postgres_data.PostgresDataApplication;
import com.data.postgres.postgres_data.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PostgresDataApplication.class})
public class BlogRepositoryTest {

    @Autowired
    BlogService blogService;

    @Test
    public void testSave() throws Exception {
        Map<String, String> content = new HashMap<>();
        content.put("title", "title test");
        content.put("content", "content text");
        content.put("mdSource", "### title");
       blogService.createNewBlog(content);
    }
}