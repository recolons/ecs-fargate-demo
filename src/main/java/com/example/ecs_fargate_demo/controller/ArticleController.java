package com.example.ecs_fargate_demo.controller;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // get all articles - PUBLIC
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // get article by id - PUBLIC
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable String id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // create article - EDITOR ONLY
    @PostMapping
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    // update article - EDITOR ONLY
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public ResponseEntity<Article> updateArticle(@PathVariable String id, @RequestBody Article articleDetails) {
        try {
            Article updatedArticle = articleService.updateArticle(id, articleDetails);
            return ResponseEntity.ok(updatedArticle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete article - EDITOR ONLY
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
        try {
            articleService.deleteArticle(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get all articles by section - PUBLIC
    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<Article>> getArticlesBySection(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySection(section);
        return ResponseEntity.ok(articles);
    }

    // get all articles by section with pagination - PUBLIC
    @GetMapping("/section/{sectionId}/page")
    public ResponseEntity<Page<Article>> getArticlesBySection(
            @PathVariable Long sectionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "datePublished") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {
        Section section = new Section();
        section.setId(sectionId);
        Page<Article> articles = articleService.getArticlesBySection(section, page, size, sortBy, direction);
        return ResponseEntity.ok(articles);
    }

    // Convenience endpoints for common sorting scenarios - PUBLIC
    // newest first
    @GetMapping("/section/{sectionId}/newest")
    public ResponseEntity<List<Article>> getArticlesBySectionNewestFirst(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionNewestFirst(section);
        return ResponseEntity.ok(articles);
    }

    // oldest first
    @GetMapping("/section/{sectionId}/oldest")
    public ResponseEntity<List<Article>> getArticlesBySectionOldestFirst(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionOldestFirst(section);
        return ResponseEntity.ok(articles);
    }

    // alphabetical
    @GetMapping("/section/{sectionId}/alphabetical")
    public ResponseEntity<List<Article>> getArticlesBySectionAlphabetically(@PathVariable Long sectionId) {
        Section section = new Section();
        section.setId(sectionId);
        List<Article> articles = articleService.getArticlesBySectionAlphabetically(section);
        return ResponseEntity.ok(articles);
    }
}
