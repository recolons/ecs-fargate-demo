package com.example.ecs_fargate_demo.repository;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
    // Basic CRUD operations are automatically implemented by Spring Data JPA

    // get articles by section
    List<Article> findBySection(Section section);

    // get articles by section with pagination
    Page<Article> findBySection(Section section, Pageable pageable);
    
    // get articles by section with newest first
    List<Article> findBySectionOrderByDatePublishedDesc(Section section);

    List<Article> findBySectionOrderByTitleAsc(Section section);
    List<Article> findBySectionOrderByDatePublishedAsc(Section section);
} 