package com.example.ecs_fargate_demo.controller;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        try {
            Article updatedArticle = articleService.updateArticle(id, articleDetails);
            return ResponseEntity.ok(updatedArticle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        try {
            articleService.deleteArticle(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<Article>> getArticlesBySection(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySection(section);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/section/{sectionId}/page")
    public ResponseEntity<Page<Article>> getArticlesBySection(
            @PathVariable Long sectionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {
        Section section = new Section();
        section.setId(sectionId);
        Page<Article> articles = articleService.getArticlesBySection(section, page, size, sortBy, direction);
        return ResponseEntity.ok(articles);
    }

    // Convenience endpoints for common sorting scenarios
    @GetMapping("/section/{sectionId}/newest")
    public ResponseEntity<List<Article>> getArticlesBySectionNewestFirst(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionNewestFirst(section);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/section/{sectionId}/oldest")
    public ResponseEntity<List<Article>> getArticlesBySectionOldestFirst(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionOldestFirst(section);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/section/{sectionId}/alphabetical")
    public ResponseEntity<List<Article>> getArticlesBySectionAlphabetically(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionAlphabetically(section);
        return ResponseEntity.ok(articles);
    }
}
