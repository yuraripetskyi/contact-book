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

import java.util.List;
import java.util.Optional;

@Controller
public class SecondController {
    @Autowired
    UserService userService;
    @Autowired
    ContactService contactService;

    @PostMapping("/user/{id}/contact/create")
    public String createContact(
            @PathVariable int id,
            @RequestParam String nameCon,
            @RequestParam String surnameCon,
            @RequestParam String numberCon
    ){
        Optional<User> byId = userService.findById(id);
        User user = byId.get();
        List<Contact> list_of_contacts = user.getList_of_contacts();
        Contact contact = new Contact(nameCon,surnameCon,Integer.parseInt(numberCon),user);
        contactService.save(contact);
        list_of_contacts.add(contact);
        user.setList_of_contacts(list_of_contacts);
        userService.save(user);
        return "redirect:/user/{id}";
    }

    @GetMapping("/user/{id}/contact/{idCon}")
    public String getContact(
            @PathVariable int id,
            @PathVariable int idCon,
            Model model
    ){
        Optional<User> user = userService.findById(id);
        User user1 = user.get();
        model.addAttribute("user",user1);
        //List<Contact> list_of_contacts = user1.getList_of_contacts();
        Optional<Contact> byId = contactService.findById(idCon);
        Contact contact = byId.get();
        model.addAttribute("contact",contact);
        return "contact";
    }

   @GetMapping("/user/{id}/contact/{idCon}/delete")
    public String deleteContact(
            @PathVariable int id,
            @PathVariable int idCon
   ){
       /*Optional<User> byId = userService.findById(id);
       User user = byId.get();
       List<Contact> list_of_contacts = user.getList_of_contacts();
       Optional<Contact> byId1 = contactService.findById(idCon);
       list_of_contacts.remove(byId1);
       userService.save(user);*/
       Optional<Contact> byId = contactService.findById(idCon);
       Contact contact = byId.get();
       System.out.println(contact.toString());
       contactService.deleteById(idCon);
       return "redirect:/user/{id}";
   }
}
