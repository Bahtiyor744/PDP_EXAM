package com.example.pdp_project.service;

import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class VerificationService {
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;


    public void sendEmail(String email) {
        String code = String.valueOf(new Random().nextInt(9000) + 1000);
        User user = userRepository.findByEmail(email);
        user.setCode(code);
        userRepository.save(user);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your confirmation code");
        message.setText("Your code: " + code);
        mailSender.send(message);
        System.out.println(code);
    }
    public boolean verifyCode(String email, String code) {
        User user = userRepository.findByEmail(email);
        return code.equals(user.getCode());
    }
}
