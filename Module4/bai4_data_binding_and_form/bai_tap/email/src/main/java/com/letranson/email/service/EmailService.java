package com.letranson.email.service;

import com.letranson.email.model.Email;

import java.util.List;

public interface EmailService {
    List<Email> showAll();
    void addEmail(Email email);
}
