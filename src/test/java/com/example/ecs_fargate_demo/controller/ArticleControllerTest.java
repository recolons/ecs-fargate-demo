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
    private static final String TEST_ARTICLE_ID = "123e4567-e89b-12d3-a456-426614174000";
    private static final String NON_EXISTENT_ARTICLE_ID = "999e4567-e89b-12d3-a456-426614174000";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testSection = new Section();
        testSection.setId(1L);
        testSection.setName("Test Section");

        testArticle = new Article();
        testArticle.setId(TEST_ARTICLE_ID);
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
        when(articleService.getArticleById(TEST_ARTICLE_ID)).thenReturn(Optional.of(testArticle));

        // Act
        ResponseEntity<Article> response = articleController.getArticleById(TEST_ARTICLE_ID);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testArticle, response.getBody());
        verify(articleService, times(1)).getArticleById(TEST_ARTICLE_ID);
    }

    @Test
    void getArticleById_WhenArticleDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        when(articleService.getArticleById(NON_EXISTENT_ARTICLE_ID)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Article> response = articleController.getArticleById(NON_EXISTENT_ARTICLE_ID);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
        verify(articleService, times(1)).getArticleById(NON_EXISTENT_ARTICLE_ID);
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
        when(articleService.updateArticle(eq(TEST_ARTICLE_ID), any(Article.class))).thenReturn(testArticle);

        // Act
        ResponseEntity<Article> response = articleController.updateArticle(TEST_ARTICLE_ID, testArticle);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testArticle, response.getBody());
        verify(articleService, times(1)).updateArticle(TEST_ARTICLE_ID, testArticle);
    }

    @Test
    void deleteArticle_WhenArticleExists_ShouldReturnOk() {
        // Arrange
        doNothing().when(articleService).deleteArticle(TEST_ARTICLE_ID);

        // Act
        ResponseEntity<Void> response = articleController.deleteArticle(TEST_ARTICLE_ID);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(articleService, times(1)).deleteArticle(TEST_ARTICLE_ID);
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