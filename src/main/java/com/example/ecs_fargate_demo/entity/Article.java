package com.example.ecs_fargate_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @UuidGenerator
    private String id;

    private String title;

    private String author;

    private String description;

    private String imageUrl1;

    private String imageUrl2;

    private String imageUrl3;

    private String content;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Column(name = "date_published", nullable = false, updatable = false)
    private LocalDateTime datePublished;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @PrePersist
    protected void onCreate() {
        datePublished = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdated = LocalDateTime.now();
    }
}