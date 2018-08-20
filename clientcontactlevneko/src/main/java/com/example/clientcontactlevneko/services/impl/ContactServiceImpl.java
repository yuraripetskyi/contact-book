package com.example.clientcontactlevneko.services.impl;


import com.example.clientcontactlevneko.dao.ContactDAO;
import com.example.clientcontactlevneko.models.Contact;
import com.example.clientcontactlevneko.services.serv.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactDAO contactDAO;

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public Optional<Contact> findById(int id) {
        return contactDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        contactDAO.deleteById(id);
    }
}
