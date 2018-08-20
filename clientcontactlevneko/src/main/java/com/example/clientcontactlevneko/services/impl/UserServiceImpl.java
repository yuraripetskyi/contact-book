package com.example.clientcontactlevneko.services.impl;

import com.example.clientcontactlevneko.dao.UserDAO;
import com.example.clientcontactlevneko.models.User;
import com.example.clientcontactlevneko.services.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

}
