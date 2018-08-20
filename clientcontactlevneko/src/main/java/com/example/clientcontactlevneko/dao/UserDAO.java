package com.example.clientcontactlevneko.dao;

import com.example.clientcontactlevneko.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
}
