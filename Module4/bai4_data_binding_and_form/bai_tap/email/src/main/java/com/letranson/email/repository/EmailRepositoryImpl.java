package com.letranson.email.repository;

import com.letranson.email.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailRepositoryImpl implements EmailRepository {
    static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email("Vietnamese",25,true,"Welcome to Vietnam"));
        emailList.add(new Email("English",25,true,"Welcome to Vietnam"));
        emailList.add(new Email("Chinese",25,true,"Welcome to Vietnam"));
    }

    @Override
    public List<Email> showAll() {
        return emailList;
    }

    @Override
    public void addEmail(Email email) {
        emailList.add(email);
    }
}
