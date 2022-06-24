package com.example.beerbar_webapp.controller;

import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    JDBConnection connection = new JDBConnection();
    JDBConnection connection1 = new JDBConnection();
    UserDAOImpl resultDAO = new UserDAOImpl(connection);
    UserDAOImpl userDAO = new UserDAOImpl(connection1);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        String password = request.getParameter("password");
        String passcofirm = request.getParameter("password_confirm");
        String gender = request.getParameter("gender");
        String number = request.getParameter("phone_number");

        User user = new User(name, login, password, age, gender, email, number, address, surname);

        if (!Objects.equals(passcofirm, password)) {
            response.sendRedirect(request.getContextPath() + "/errors/wronPass.jsp");
        }
        if (resultDAO.create(user)) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("name", user.getName());
                session.setAttribute("surname", user.getSurname());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("age", user.getAge());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("gender", user.getGender());
                session.setAttribute("phone_number", user.getPhoneNumber());
                session.setAttribute("address", user.getAddress());
                response.sendRedirect(request.getContextPath() + "/profile.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/errors/404error.jsp");
        }
    }
}
