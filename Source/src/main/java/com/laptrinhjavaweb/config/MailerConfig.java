package com.laptrinhjavaweb.config;

import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.springsupport.SimpleJavaMailSpringSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SimpleJavaMailSpringSupport.class)
public class MailerConfig {
    @Autowired
    private Mailer mailer;
}
