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

    public Optional<Article> getArticleById(String id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(String id, Article articleDetails) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
        
        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());
        article.setDatePublished(articleDetails.getDatePublished());
        article.setDateUpdated(articleDetails.getDateUpdated());
        article.setAuthor(articleDetails.getAuthor());
        article.setImageUrl1(articleDetails.getImageUrl1());
        article.setImageUrl2(articleDetails.getImageUrl2());
        article.setImageUrl3(articleDetails.getImageUrl3());
        article.setDescription(articleDetails.getDescription());
        
        return articleRepository.save(article);
    }

    public void deleteArticle(String id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
        articleRepository.delete(article);
    }

    private Section validateSection(Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(() -> new SectionNotFoundException(sectionId));
    }

    // get articles by section
    public List<Article> getArticlesBySection(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySection(section);
    }

    // get articles by section with pagination and sorting
    public Page<Article> getArticlesBySection(Section section, int page, int size, String sortBy, String direction) {
        validateSection(section.getId());
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        return articleRepository.findBySection(section, pageable);
    }

    // Convenience methods for common sorting scenarios
    // articles by section newest first
    public List<Article> getArticlesBySectionNewestFirst(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByDatePublishedDesc(section);
    }

    // articles by section oldest first
    public List<Article> getArticlesBySectionOldestFirst(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByDatePublishedAsc(section);
    }

    // articles by section alphabetically
    public List<Article> getArticlesBySectionAlphabetically(Section section) {
        validateSection(section.getId());
        return articleRepository.findBySectionOrderByTitleAsc(section);
    }
} 