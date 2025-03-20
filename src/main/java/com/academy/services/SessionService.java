package com.academy.services;

import jakarta.mail.Authenticator;
import jakarta.mail.Session;

import java.util.Properties;

public class SessionService {
    private Properties properties;
    private Authenticator authenticator;

    public SessionService(Properties properties, Authenticator authenticator) {
        this.properties = properties;
        this.authenticator = authenticator;
    }

    public Session getSession() {
        return Session.getInstance(this.properties, this.authenticator);
    }
}
