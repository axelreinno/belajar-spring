package com.academy.configs;

import com.academy.Author;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {
    @Bean
    public Author author() {
        Author author = new Author();
        author.setName("Axel");
        return author;
    }
}
