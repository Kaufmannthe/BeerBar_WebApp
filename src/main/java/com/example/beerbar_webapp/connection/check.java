package com.example.beerbar_webapp.connection;

import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

public class check {
    public static void main(String[] args) {
        JDBConnection jdbConnection = new JDBConnection();
        UserDAOImpl userDAO = new UserDAOImpl(jdbConnection);
        System.out.println(userDAO.create(new User("Darya","Darya123","12345",20,"Female","Darya@mail.ru","+3755122211","Belarus, Minsk","Burdyko")));
    }
}
