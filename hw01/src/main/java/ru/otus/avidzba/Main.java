package ru.otus.avidzba;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.avidzba.service.QuestionService;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        context.close();

        questionService.findAll().forEach(x -> System.out.println(x.getQuestion()));

    }
}
