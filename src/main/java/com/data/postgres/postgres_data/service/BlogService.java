package com.data.postgres.postgres_data.service;

import com.data.postgres.postgres_data.dto.Blog;
import com.data.postgres.postgres_data.repo.BlogRepository;
import com.data.postgres.postgres_data.util.FileReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public String getBlog(Integer id) throws IOException {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            String location = blog.getLocation();
            return FileReaderUtil.readBlogByLocation(location);
        }
        throw new NoSuchElementException();
    }
}
