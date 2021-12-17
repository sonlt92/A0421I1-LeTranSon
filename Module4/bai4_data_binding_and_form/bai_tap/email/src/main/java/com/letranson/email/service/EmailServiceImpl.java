package com.letranson.email.service;

import com.letranson.email.model.Email;
import com.letranson.email.repository.EmailRepository;
import com.letranson.email.repository.EmailRepositoryImpl;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    EmailRepository emailRepository = new EmailRepositoryImpl();

    @Override
    public List<Email> showAll(){
        return emailRepository.showAll();
    }

    @Override
    public void addEmail(Email email){
        emailRepository.addEmail(email);
    }
}
