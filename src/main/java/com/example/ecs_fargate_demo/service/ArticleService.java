package com.example.ecs_fargate_demo.service;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.exception.SectionNotFoundException;
import com.example.ecs_fargate_demo.repository.ArticleRepository;
import com.example.ecs_fargate_demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, SectionRepository sectionRepository) {
        this.articleRepository = articleRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article articleDetails) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
        
        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());
        article.setDate(articleDetails.getDate());
        
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
        articleRepository.delete(article);
    }

    private Section validateSection(Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(() -> new SectionNotFoundException(sectionId));
    }

    public List<Article> getArticlesBySection(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySection(section);
    }

    public Page<Article> getArticlesBySection(Section section, int page, int size, String sortBy, String direction) {
        validateSection(section.getId());
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        return articleRepository.findBySection(section, pageable);
    }

    // Convenience methods for common sorting scenarios
    public List<Article> getArticlesBySectionNewestFirst(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByDateDesc(section);
    }

    public List<Article> getArticlesBySectionOldestFirst(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByDateAsc(section);
    }

    public List<Article> getArticlesBySectionAlphabetically(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByTitleAsc(section);
    }
} 