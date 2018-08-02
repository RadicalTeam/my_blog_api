package com.data.postgres.my_blog_api.controller;

import com.data.postgres.my_blog_api.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/upload")
public class UploadController {
    @Autowired
    UploadService uploadService;

    @PostMapping
    public String uploadSingleFile(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) {
        try {
            uploadService.saveFile(file, title);
            return "Succeed";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }
    }

}
