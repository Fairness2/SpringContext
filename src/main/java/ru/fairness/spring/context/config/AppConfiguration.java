package ru.fairness.spring.context.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.fairness.spring.context.components.App;
import ru.fairness.spring.context.repositories.ProductRepository;

@Configuration
@ComponentScan("ru.fairness.spring.context")
public class AppConfiguration {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private App app;
}
