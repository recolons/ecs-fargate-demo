package com.example.ecs_fargate_demo.repository;

import com.example.ecs_fargate_demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Basic CRUD operations are automatically implemented by Spring Data JPA
} 