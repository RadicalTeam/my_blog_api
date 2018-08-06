package com.data.postgres.my_blog_api.repo;

import com.data.postgres.my_blog_api.dto.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByPublishedIsTrue();

    @Modifying
    @Query("update Blog b set b.brief=:brief, b.title=:title where b.id=:id")
    void updateBlog(@Param("brief") String brief,
                    @Param("title") String title,
                    @Param("id") Integer id);
}
