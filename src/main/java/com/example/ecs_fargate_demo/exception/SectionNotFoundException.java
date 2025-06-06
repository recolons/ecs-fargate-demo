package com.example.ecs_fargate_demo.exception;

public class SectionNotFoundException extends RuntimeException {
    public SectionNotFoundException(Long sectionId) {
        super("Section not found with id: " + sectionId);
    }
} 