package com.example.clientcontactlevneko.dao;

import com.example.clientcontactlevneko.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDAO extends JpaRepository<Contact,Integer>{
}
