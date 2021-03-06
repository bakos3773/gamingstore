package com.bakos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String to, String title, String contents) {

        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("p.bakowski1@gmail.com");
            helper.setFrom("p.bakowski1@gmail.com");
            helper.setSubject(title);
            helper.setText(contents);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);

    }
}
