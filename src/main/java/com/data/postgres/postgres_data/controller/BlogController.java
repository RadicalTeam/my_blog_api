package com.data.postgres.postgres_data.controller;

import com.data.postgres.postgres_data.dto.Blog;
import com.data.postgres.postgres_data.service.BlogService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewBlog(@RequestParam String title, @RequestParam String location) {
        Blog blog = new Blog();
        blog.setBlog_title(title);
        blog.setLocation(location);
        blogService.saveBlog(blog);
        return "Saved";
    }

    @GetMapping(path= "/{id}")
    public Object getBlogById(@PathVariable Integer id){
        String content;
        try {
           content = blogService.getBlog(id);
        } catch (IOException e) {
            e.printStackTrace();
            content = "No such blog";
        }
        Map<String, String> resMap = new HashMap<>();
        resMap.put("content", content);
        return resMap;
    }

}
