package com.academy;

import com.academy.services.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        Book book = (Book) context.getBean("book");
//        System.out.println(book.getTitle());

        EmailService emailService = (EmailService) context.getBean("emailService");
        try {
            emailService.sendMail();
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
