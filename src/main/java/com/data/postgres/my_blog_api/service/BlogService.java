package com.data.postgres.my_blog_api.service;

import com.data.postgres.my_blog_api.dto.Blog;
import com.data.postgres.my_blog_api.repo.BlogRepository;
import com.data.postgres.my_blog_api.util.FileReaderUtil;
import com.data.postgres.my_blog_api.util.FileWriterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    public List<Blog> getAllBlogs() {
        return blogRepository.findAllByPublishedIsTrue();
    }

    public void createNewBlog(Map<String, String> content) throws IOException {
        String prefixFileName = UUID.randomUUID().toString();
        byte[] MDSource = content.get("mdSource").getBytes();
        byte[] HTMLSource = content.get("content").getBytes();
        Files.write(FileWriterUtil.getNewMDFilePath(prefixFileName), MDSource);
        Files.write(FileWriterUtil.getNewHTMLFilePath(prefixFileName), HTMLSource);

        Blog blog = new Blog();
        Date createDate = new Date();
        blog.setTitle(content.get("title"));
        blog.setBrief(content.get("brief"));
        blog.setLocation(FileReaderUtil.BLOG_FOLDER.concat(File.separator).concat(prefixFileName));
        blog.setCreateAt(createDate);
        blogRepository.save(blog);
    }

    @Transactional
    public void updateBlog(Map<String, String> blog) throws IOException {
        String originId = blog.get("id");
        if (originId != null && blogRepository.existsById(Integer.parseInt(blog.get("id")))) {
            Integer blogId = Integer.parseInt(blog.get("id"));
            updateFile(blog.get("mdSource"), blogId);
            blogRepository.updateBlog(blog.get("brief"), blog.get("title"), blogId);
        }
    }

    void updateFile(String content, Integer id) throws IOException {
        Blog blog = blogRepository.findById(id).get();
        FileWriterUtil.updateMDFile(blog.getLocation(), content);
    }

}
