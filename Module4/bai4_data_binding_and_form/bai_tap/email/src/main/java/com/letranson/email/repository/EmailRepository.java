package com.letranson.email.repository;

import com.letranson.email.model.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> showAll();

    void addEmail(Email email);

}
