package com.academy.configs;

import com.academy.Author;
import com.academy.Book;
import com.academy.services.EmailService;
import jakarta.mail.Authenticator;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import jakarta.mail.PasswordAuthentication;

import java.util.Properties;

public class ApplicationConfig {
    @Bean
    public Author author() {
        Author author = new Author();
        author.setId(1);
        author.setName("Axel");
        return author;
    }

    @Bean
    public Book book(Author author) {
        Book book = new Book("The Lost Art", author);
        return book;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("d1268cdd35952e", "34ff9375651117");
    }

    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        return properties;
    }

    @Bean
    public Session mailSession(@Qualifier("properties") Properties properties, PasswordAuthentication authentication) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
    }

    @Bean
    public EmailService emailService(Session mailSession) {
        return new EmailService(mailSession);
    }
}
