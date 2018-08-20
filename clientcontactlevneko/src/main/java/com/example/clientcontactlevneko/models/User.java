package com.example.clientcontactlevneko.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString(exclude = {"list_of_contacts"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private List<Contact> list_of_contacts;

    public User(String name, String surname, int age, List<Contact> list_of_contacts) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.list_of_contacts = list_of_contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Contact> getList_of_contacts() {
        return list_of_contacts;
    }

    public void setList_of_contacts(List<Contact> list_of_contacts) {
        this.list_of_contacts = list_of_contacts;
    }
}
