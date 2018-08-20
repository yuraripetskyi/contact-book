package com.example.clientcontactlevneko.services.serv;

import com.example.clientcontactlevneko.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    void deleteById(int id);

    //oid updateUserById(int id);
}
