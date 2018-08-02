package com.data.postgres.my_blog_api.service;

import com.data.postgres.my_blog_api.dto.Blog;
import com.data.postgres.my_blog_api.repo.BlogRepository;
import com.data.postgres.my_blog_api.util.FileReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public String getBlog(Integer id) throws IOException {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            String location = blog.getLocation()  + ".html";
            return FileReaderUtil.readBlogByLocation(location);
        }
        throw new NoSuchElementException();
    }

    public void createNewBlog(Map<String, String> content) throws IOException {
        String prefixFileName = UUID.randomUUID().toString();
//        byte[] MDSource = content.get("mdSource").getBytes();
//        byte[] HTMLSource = content.get("content").getBytes();
//        Files.write(FileWriterUtil.getNewMDFilePath(prefixFileName), MDSource);
//        Files.write(FileWriterUtil.getNewHTMLFilePath(prefixFileName), HTMLSource);

        Blog blog = new Blog();
        Date createDate = new Date();
        blog.setTitle(content.get("title"));
        blog.setLocation(FileReaderUtil.BLOG_FOLDER.concat(File.separator).concat(prefixFileName));
        blog.setCreateAt(createDate);
        blogRepository.save(blog);
    }
}
