package com.example.ecs_fargate_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import com.example.ecs_fargate_demo.repository.ArticleRepository;

@SpringBootTest
@ActiveProfiles("test")
@DataJpaTest
@Import(ArticleRepository.class)
class EcsFargateDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
