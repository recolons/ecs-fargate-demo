package com.example.ecs_fargate_demo.repository;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Basic CRUD operations are automatically implemented by Spring Data JPA
    List<Article> findBySection(Section section);
    Page<Article> findBySection(Section section, Pageable pageable);
    
    // Add sorting options
    List<Article> findBySectionOrderByDateDesc(Section section);
    List<Article> findBySectionOrderByTitleAsc(Section section);
    List<Article> findBySectionOrderByDateAsc(Section section);
} 