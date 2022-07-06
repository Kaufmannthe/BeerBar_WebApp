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

public class LoginCommandImpl implements Command {
    JDBConnection connection = new JDBConnection();
    JDBConnection connection1 = new JDBConnection();
    UserDAOImpl resultDAO = new UserDAOImpl(connection);
    UserDAOImpl userDAO = new UserDAOImpl(connection1);


    @Override
    public CommandResult execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        CommandResult commandResult = new CommandResult();
        String page;
        boolean result = resultDAO.findUser(login, password);
        User user = userDAO.getUser(login, password);
        if (result) {

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
