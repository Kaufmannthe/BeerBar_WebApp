package com.example.beerbar_webapp.controller;

import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "profile", value = "/profile")
public class HelloServlet extends HttpServlet {
    JDBConnection connection = new JDBConnection();
    JDBConnection connection1 = new JDBConnection();
    UserDAOImpl resultDAO = new UserDAOImpl(connection);
    UserDAOImpl userDAO = new UserDAOImpl(connection1);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        try {
            boolean result = resultDAO.findUser(login, password);
            User user = userDAO.getUser(login, password);
            if (result) {
                HttpSession session = request.getSession();
                session.setAttribute("name", user.getName());
                session.setAttribute("surname",user.getSurname());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("age", user.getAge());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("gender", user.getGender());
                session.setAttribute("phone_number", user.getPhoneNumber());
                session.setAttribute("address", user.getAddress());

                response.sendRedirect(request.getContextPath() + "/profile.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/errors/404error.jsp");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void destroy() {
    }
}