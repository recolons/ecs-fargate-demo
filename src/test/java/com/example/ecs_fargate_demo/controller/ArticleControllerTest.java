package com.example.ecs_fargate_demo.controller;

import com.example.ecs_fargate_demo.entity.Article;
import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    private Article testArticle;
    private Section testSection;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testSection = new Section();
        testSection.setId(1L);
        testSection.setName("Test Section");

        testArticle = new Article();
        testArticle.setId(1L);
        testArticle.setTitle("Test Article");
        testArticle.setSection(testSection);
    }

    @Test
    void getAllArticles_ShouldReturnAllArticles() {
        // Arrange
        List<Article> articles = Arrays.asList(testArticle);
        when(articleService.getAllArticles()).thenReturn(articles);

        // Act
        List<Article> result = articleController.getAllArticles();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testArticle, result.get(0));
        verify(articleService, times(1)).getAllArticles();
    }

    @Test
    void getArticleById_WhenArticleExists_ShouldReturnArticle() {
        // Arrange
        when(articleService.getArticleById(1L)).thenReturn(Optional.of(testArticle));

        // Act
        ResponseEntity<Article> response = articleController.getArticleById(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testArticle, response.getBody());
        verify(articleService, times(1)).getArticleById(1L);
    }

    @Test
    void getArticleById_WhenArticleDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        when(articleService.getArticleById(999L)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Article> response = articleController.getArticleById(999L);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
        verify(articleService, times(1)).getArticleById(999L);
    }

    @Test
    void createArticle_ShouldReturnCreatedArticle() {
        // Arrange
        when(articleService.createArticle(any(Article.class))).thenReturn(testArticle);

        // Act
        Article result = articleController.createArticle(testArticle);

        // Assert
        assertNotNull(result);
        assertEquals(testArticle, result);
        verify(articleService, times(1)).createArticle(testArticle);
    }

    @Test
    void updateArticle_WhenArticleExists_ShouldReturnUpdatedArticle() {
        // Arrange
        when(articleService.updateArticle(eq(1L), any(Article.class))).thenReturn(testArticle);

        // Act
        ResponseEntity<Article> response = articleController.updateArticle(1L, testArticle);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testArticle, response.getBody());
        verify(articleService, times(1)).updateArticle(1L, testArticle);
    }

    @Test
    void deleteArticle_WhenArticleExists_ShouldReturnOk() {
        // Arrange
        doNothing().when(articleService).deleteArticle(1L);

        // Act
        ResponseEntity<Void> response = articleController.deleteArticle(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(articleService, times(1)).deleteArticle(1L);
    }

    @Test
    void getArticlesBySection_ShouldReturnArticles() {
        // Arrange
        List<Article> articles = Arrays.asList(testArticle);
        when(articleService.getArticlesBySection(any(Section.class))).thenReturn(articles);

        // Act
        ResponseEntity<List<Article>> response = articleController.getArticlesBySection(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(articles, response.getBody());
        verify(articleService, times(1)).getArticlesBySection(any(Section.class));
    }

    @Test
    void getArticlesBySectionWithPagination_ShouldReturnPagedArticles() {
        // Arrange
        Page<Article> articlePage = new PageImpl<>(Arrays.asList(testArticle));
        when(articleService.getArticlesBySection(any(Section.class), anyInt(), anyInt(), anyString(), anyString()))
                .thenReturn(articlePage);

        // Act
        ResponseEntity<Page<Article>> response = articleController.getArticlesBySection(1L, 0, 10, "date", "desc");

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(articlePage, response.getBody());
        verify(articleService, times(1)).getArticlesBySection(any(Section.class), eq(0), eq(10), eq("date"), eq("desc"));
    }

    @Test
    void getArticlesBySectionNewestFirst_ShouldReturnSortedArticles() {
        // Arrange
        List<Article> articles = Arrays.asList(testArticle);
        when(articleService.getArticlesBySectionNewestFirst(any(Section.class))).thenReturn(articles);

        // Act
        ResponseEntity<List<Article>> response = articleController.getArticlesBySectionNewestFirst(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(articles, response.getBody());
        verify(articleService, times(1)).getArticlesBySectionNewestFirst(any(Section.class));
    }

    @Test
    void getArticlesBySectionAlphabetically_ShouldReturnSortedArticles() {
        // Arrange
        List<Article> articles = Arrays.asList(testArticle);
        when(articleService.getArticlesBySectionAlphabetically(any(Section.class))).thenReturn(articles);

        // Act
        ResponseEntity<List<Article>> response = articleController.getArticlesBySectionAlphabetically(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(articles, response.getBody());
        verify(articleService, times(1)).getArticlesBySectionAlphabetically(any(Section.class));
    }
} 