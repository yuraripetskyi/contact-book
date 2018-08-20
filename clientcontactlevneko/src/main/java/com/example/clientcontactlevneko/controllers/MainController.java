package com.example.clientcontactlevneko.controllers;

import com.example.clientcontactlevneko.models.Contact;
import com.example.clientcontactlevneko.models.User;
import com.example.clientcontactlevneko.services.serv.ContactService;
import com.example.clientcontactlevneko.services.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    ContactService contactService;


    @GetMapping("/")
    public String mainPage(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "index";
    }

    @PostMapping("/user/create")
    public String createUser(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String age
    ){
        List<Contact> list = new LinkedList<>();
        User user = new User(name , surname , Integer.parseInt(age),list);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String userPage(
            @PathVariable int id,
            Model model
    ){
        Optional<User> user = userService.findById(id);
        User user1 = user.get();
        model.addAttribute("user",user1);
        List<Contact> all = contactService.findAll();
        List<Contact> contacts = user1.getList_of_contacts();
        model.addAttribute("contacts",contacts);
        return "user";
    }

    @GetMapping("/user/{id}/delete")
    public String deleteUser(
            @PathVariable int id
    ){
        userService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/user/{id}/update")
    public String updateUser(
            @PathVariable int id,
            @RequestParam String name1,
            @RequestParam String surname1,
            @RequestParam String age1
    ){
        Optional<User> byId = userService.findById(id);
        User user = byId.get();
        user.setName(name1);
        user.setSurname(surname1);
        user.setAge(Integer.parseInt(age1));
        userService.save(user);
        return "redirect:/";
    }

}
