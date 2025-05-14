package com.example.ecs_fargate_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping(produces = "application/json")
    public String getAllArticles() {
        return "hello world jeje";
    }
}
