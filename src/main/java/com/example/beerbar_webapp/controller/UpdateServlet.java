package com.example.beerbar_webapp.controller;

import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    JDBConnection connection = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connection);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        String login = request.getParameter("login");

        User user = new User(name,age,gender,email,phone_number,address,surname,login);

        if (userDAO.editUser(user)){
            try{
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
        }else {
            response.sendRedirect(request.getContextPath() + "/errors/404error.jsp");
        }
    }
}
