package com.bakos.services;


public interface EmailService {

    public void send(String to, String title, String contents);
}
