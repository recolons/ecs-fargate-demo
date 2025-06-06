package com.example.ecs_fargate_demo.service;

import com.example.ecs_fargate_demo.entity.Section;
import com.example.ecs_fargate_demo.exception.SectionNotFoundException;
import com.example.ecs_fargate_demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException(id));
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section updateSection(Long id, Section sectionDetails) {
        Section section = getSectionById(id);
        section.setName(sectionDetails.getName());
        return sectionRepository.save(section);
    }

    public void deleteSection(Long id) {
        Section section = getSectionById(id);
        sectionRepository.delete(section);
    }
} 