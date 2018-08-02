package com.data.postgres.postgres_data.repo;

import com.data.postgres.postgres_data.dto.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
