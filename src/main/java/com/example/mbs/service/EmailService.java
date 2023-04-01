package com.example.mbs.service;

public interface EmailService {
    boolean sendVerificationCode(String to,String subject,String text);
}
