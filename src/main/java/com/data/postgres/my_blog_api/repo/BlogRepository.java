package com.data.postgres.my_blog_api.repo;

import com.data.postgres.my_blog_api.dto.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByPublishedIsTrue();
}
