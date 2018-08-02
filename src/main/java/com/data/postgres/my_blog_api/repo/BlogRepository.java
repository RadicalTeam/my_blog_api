package com.data.postgres.my_blog_api.repo;

import com.data.postgres.my_blog_api.dto.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
