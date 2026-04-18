package com.example.ss9.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.ss9")


public class WebConfig implements WebMvcConfigurer {
    @Bean
    public SpringResourceTemplateResolver templateResolver(ApplicationContext applicationContext){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver resolver){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(resolver);
        engine.addDialect(new LayoutDialect());
        return engine;
    }
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine viewresolver){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(viewresolver);
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
}