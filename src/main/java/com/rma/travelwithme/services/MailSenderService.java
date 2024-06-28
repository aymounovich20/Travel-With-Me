package com.rma.travelwithme.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.lang.String.format;

@Service
public class MailSenderService {

    private final JavaMailSender javaEmailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    public MailSenderService(JavaMailSender emailSender) {
        this.javaEmailSender = emailSender;
    }

    public void sendSimpleMessage(final Set<String> email, final Long groupId, final String tripName) {
        email.forEach(e -> sendEmail(e, groupId, tripName));
    }

    private void sendEmail(final String email, final Long groupId, final String tripName) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(emailSender);
        mail.setTo(email);

        String subject = format("Invitation to join the trip: %s", tripName);
        mail.setSubject(subject);

        String texte = format("Hello! \n\n You have been invited to join the trip: %s. \n\n Please click on the link below to confirm your participation:" +
                " \n http://localhost:8085/api/groups/%d \n\n LET'S MAKE THE WORLD MORE PRODUCTIVE, TOGETHER. \n ©leave App", tripName, groupId);
        mail.setText(texte);

        javaEmailSender.send(mail);
    }
}
