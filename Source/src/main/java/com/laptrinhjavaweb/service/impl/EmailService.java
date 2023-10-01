package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.EmailConverter;
import com.laptrinhjavaweb.dto.EmailDTO;
import com.laptrinhjavaweb.entity.EmailEntity;
import com.laptrinhjavaweb.repository.EmailRepository;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.IEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang.StringUtils;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.AsyncResponse;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.concurrent.Future;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailConverter emailConverter;

    @Autowired // or roll your own, as long as SimpleJavaMailSpringSupport is processed first
    private Mailer mailer;

    @Autowired
    private Configuration fmConfiguration;

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public EmailDTO save(EmailDTO emailDTO) {
        EmailEntity result = emailRepository.save(emailConverter.convertToEntity(emailDTO));
        return emailConverter.convertToDto(result);
    }

    @Override
    @Transactional
    public void sentMailAuto(EmailDTO emailDTO) throws Exception {
        List<Future> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        try {
            String contentTemplate = geContentFromTemplate(emailDTO);
            String[] toMails = emailDTO.getToMails().split(",");
            for (String toMail : toMails) {
                AsyncResponse resp = mailer.sendMail(newEmail(toMail, emailDTO, contentTemplate), true);
                resp.onException(Throwable::printStackTrace);
                futures.add(resp.getFuture());
            }
            for (Future future : futures) {
                future.get();
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            System.out.println(String.format("***ELAPSED TIME: %.2f seconds", elapsedTime / 1000d));
        } catch (Throwable t) {
            throw new Exception("Sending error!" +  t.getMessage());
        }
    }

    private Email newEmail(String toMail, EmailDTO emailDTO, String template) throws NoSuchProviderException {
        return EmailBuilder.startingBlank()
                .from("truonglam@laptrinhjavaweb.com")
                .to(toMail)
                .withSubject(emailDTO.getTitle())
                .withHTMLText(template)
                .buildEmail();
    }

    private String geContentFromTemplate(EmailDTO emailDTO) throws NoSuchProviderException {
        String seoContent = postRepository.findBySeoUrl(emailDTO.getSeoUrl()).getContent();
        Map<String, Object> model = new HashMap<>();
        model.put("content", seoContent);
        try {
            Template t = fmConfiguration.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            return html;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
