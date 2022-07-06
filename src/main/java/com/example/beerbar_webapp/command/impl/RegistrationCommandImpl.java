package com.example.beerbar_webapp.command.impl;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.command.NavigationType;
import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;
import com.example.beerbar_webapp.util.PageManager;
import com.example.beerbar_webapp.util.PageMappingConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class RegistrationCommandImpl implements Command {
    JDBConnection connection = new JDBConnection();
    UserDAOImpl resultDAO = new UserDAOImpl(connection);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult = new CommandResult();
        String page;
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
            /*response.sendRedirect(request.getContextPath() + "/errors/wronPass.jsp");*/
        }
        if (resultDAO.create(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", user.getName());
            session.setAttribute("surname", user.getSurname());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("age", user.getAge());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("gender", user.getGender());
            session.setAttribute("phone_number", user.getPhoneNumber());
            session.setAttribute("address", user.getAddress());
            page = request.getContextPath() + PageManager.getPageURL(PageMappingConst.PAGE_PROFILE.getKey());
            commandResult.setPage(page);
            commandResult.setType(NavigationType.REDIRECT);
        } else {
            /*response.sendRedirect(request.getContextPath() + "/errors/404error.jsp");*/

        }
        return commandResult;
    }
}
