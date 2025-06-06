package com.example.ecs_fargate_demo.repository;

import com.example.ecs_fargate_demo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
} 