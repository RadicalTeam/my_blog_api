package com.data.postgres.my_blog_api.service;

import com.data.postgres.my_blog_api.dto.Blog;
import com.data.postgres.my_blog_api.repo.BlogRepository;
import com.data.postgres.my_blog_api.util.FileReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {
    @Autowired
    BlogRepository blogRepository;

    public void saveFile(MultipartFile file, String title) throws IOException {
        if (file != null) {
           byte[] bytes = file.getBytes();
           Path path = Paths.get(FileReaderUtil.BLOG_FOLDER, file.getOriginalFilename());
           Files.write(path, bytes);

           String fileStoreLocation = FileReaderUtil.BLOG_FOLDER + "/" + file.getOriginalFilename();
            Blog blog = new Blog();
            blog.setLocation(fileStoreLocation);
            blog.setTitle(title);
            blogRepository.save(blog);
       }
    }
}
