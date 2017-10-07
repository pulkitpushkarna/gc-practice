package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Jitendra Singh.
 */
@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String message) {
        sendEmail(to, null, subject, message);
    }

    public void sendEmail(String to, String cc, String subject, String message) {
        String[] toList = StringUtils.isEmpty(to) ? null : new String[] {to};
        String[] ccList = StringUtils.isEmpty(cc) ? null : new String[] {cc};
        sendEmail(toList, ccList, subject, message);
    }

    public void sendEmail(String[] to, String[] cc, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setCc(cc);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
