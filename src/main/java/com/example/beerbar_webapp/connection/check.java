package com.example.beerbar_webapp.connection;

import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

public class check {
    public static void main(String[] args) {
        JDBConnection jdbConnection = new JDBConnection();
        UserDAOImpl userDAO = new UserDAOImpl(jdbConnection);
        User user = new User("Artyom",23,"Male","Kaufmannthe@gmail.com","+375445121346","Belarus,Minsk","Bohan","Kaufmannthe");
        System.out.println(userDAO.editUser(user));
    }
}

