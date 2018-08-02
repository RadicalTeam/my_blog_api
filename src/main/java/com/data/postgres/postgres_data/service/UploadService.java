package com.data.postgres.postgres_data.service;

import com.data.postgres.postgres_data.dto.Blog;
import com.data.postgres.postgres_data.repo.BlogRepository;
import com.data.postgres.postgres_data.util.FileReaderUtil;
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
            blog.setBlog_title(title);
            blogRepository.save(blog);
       }
    }
}
