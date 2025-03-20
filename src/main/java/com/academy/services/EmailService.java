package com.academy.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class EmailService {
    private String username;
    private String password;

    private final Properties prop;
    private SessionService sessionService;

    public EmailService(Properties properties, SessionService sessionService) {
        prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", properties.get("host"));
        prop.put("mail.smtp.port", properties.get("port"));
        prop.put("mail.smtp.ssl.trust", properties.get("host"));

        this.username = properties.get("username").toString();
        this.password = properties.get("password").toString();
        this.sessionService = sessionService;

        System.out.println(this.username);
        System.out.println(this.password);
        System.out.println(properties.get("host"));
        System.out.println(properties.get("port"));
    }

    public void sendMail() throws Exception {
        Session session = sessionService.getSession();

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("spring@mailinator.com"));
        message.setSubject("Mail Subject");
        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }


//    private Session getSession() {
//        Session session = Session.getInstance(prop, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        return session;
//    }
}
