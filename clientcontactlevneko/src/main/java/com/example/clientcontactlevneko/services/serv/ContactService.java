package com.example.clientcontactlevneko.services.serv;

import com.example.clientcontactlevneko.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    void save(Contact contact);

    List<Contact> findAll();

    Optional<Contact> findById(int id);

    void deleteById(int id);
}
