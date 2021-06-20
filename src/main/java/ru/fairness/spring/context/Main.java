package ru.fairness.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fairness.spring.context.components.App;
import ru.fairness.spring.context.config.AppConfiguration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfiguration.class);

        App app = context.getBean("app", App.class);

        app.run();
    }
}
