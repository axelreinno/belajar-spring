package com.academy;

import com.academy.configs.ApplicationConfig;
import com.academy.services.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        Book book = (Book) context.getBean("book");
//        System.out.println(book.getTitle());
//
//        EmailService emailService = (EmailService) context.getBean("emailService");
//        try {
//            emailService.sendMail();
//            System.out.println("Email sent successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Author author = (Author) context.getBean("author");
        System.out.println(author.getName());

        Book book = (Book) context.getBean("book");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor().getName());

        EmailService emailService = (EmailService) context.getBean("emailService");
        try {
            emailService.sendMail();
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
