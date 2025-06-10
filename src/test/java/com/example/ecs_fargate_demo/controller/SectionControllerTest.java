package com.example.ecs_fargate_demo.controller;

import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SectionControllerTest {

    @Mock
    private SectionService sectionService;

    @InjectMocks
    private SectionController sectionController;

    private Section testSection;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testSection = new Section();
        testSection.setId(1L);
        testSection.setName("Test Section");
    }

    @Test
    void getAllSections_ShouldReturnAllSections() {
        // Arrange
        List<Section> sections = Arrays.asList(testSection);
        when(sectionService.getAllSections()).thenReturn(sections);

        // Act
        List<Section> result = sectionController.getAllSections();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testSection, result.get(0));
        verify(sectionService, times(1)).getAllSections();
    }

    @Test
    void getSectionById_WhenSectionExists_ShouldReturnSection() {
        // Arrange
        when(sectionService.getSectionById(1L)).thenReturn(testSection);

        // Act
        ResponseEntity<Section> response = sectionController.getSectionById(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testSection, response.getBody());
        verify(sectionService, times(1)).getSectionById(1L);
    }

    @Test
    void getSectionById_WhenSectionDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        when(sectionService.getSectionById(999L)).thenThrow(new RuntimeException("Section not found"));

        // Act
        ResponseEntity<Section> response = sectionController.getSectionById(999L);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
        verify(sectionService, times(1)).getSectionById(999L);
    }

    @Test
    void getSectionByName_WhenSectionExists_ShouldReturnSection() {
        // Arrange
        when(sectionService.getSectionByName("Test Section")).thenReturn(testSection);

        // Act
        ResponseEntity<Section> response = sectionController.getSectionByName("Test Section");

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testSection, response.getBody());
        verify(sectionService, times(1)).getSectionByName("Test Section");
    }

    @Test
    void createSection_ShouldReturnCreatedSection() {
        // Arrange
        when(sectionService.createSection(any(Section.class))).thenReturn(testSection);

        // Act
        ResponseEntity<Section> response = sectionController.createSection(testSection);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testSection, response.getBody());
        verify(sectionService, times(1)).createSection(testSection);
    }

    @Test
    void updateSection_WhenSectionExists_ShouldReturnUpdatedSection() {
        // Arrange
        when(sectionService.updateSection(eq(1L), any(Section.class))).thenReturn(testSection);

        // Act
        ResponseEntity<Section> response = sectionController.updateSection(1L, testSection);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(testSection, response.getBody());
        verify(sectionService, times(1)).updateSection(1L, testSection);
    }

    @Test
    void deleteSection_WhenSectionExists_ShouldReturnOk() {
        // Arrange
        doNothing().when(sectionService).deleteSection(1L);

        // Act
        ResponseEntity<Void> response = sectionController.deleteSection(1L);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(sectionService, times(1)).deleteSection(1L);
    }
} 