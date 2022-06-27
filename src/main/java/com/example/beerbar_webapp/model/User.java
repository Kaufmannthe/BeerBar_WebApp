package com.example.beerbar_webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private String login;
    private String password;
    private int id;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String surname;

    public User(String name, String login, String password, int age, String gender,
                String email, String phoneNumber, String address, String surname) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.surname = surname;
    }

    public User(String name, int age, String gender, String email, String phoneNumber, String address, String surname, String login) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.surname = surname;
        this.login = login;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
