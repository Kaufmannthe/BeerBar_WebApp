package com.example.beerbar_webapp.repository;

import com.example.beerbar_webapp.model.User;

import java.util.Optional;

public interface UserDAO extends BaseDAO <User>{
    boolean update(User entity);

    User findByLogin(String name);

    boolean findUser (String login, String password);

    User getUser(String login, String password);

    boolean editUser(User user);
}
