package com.example.beerbar_webapp.command.impl.profile_changers;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.command.NavigationType;
import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;
import com.example.beerbar_webapp.util.PageManager;
import com.example.beerbar_webapp.util.PageMappingConst;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateProfileImpl implements Command {
    JDBConnection connection = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connection);
    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult = new CommandResult();
        String page;

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
                HttpSession session = request.getSession();
                session.setAttribute("name", user.getName());
                session.setAttribute("surname", user.getSurname());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("age", user.getAge());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("gender", user.getGender());
                session.setAttribute("phone_number", user.getPhoneNumber());
                session.setAttribute("address", user.getAddress());

                page = request.getContextPath() + PageManager.getPageURL(PageMappingConst.PAGE_SUCCESS_UPDATE.getKey());
                commandResult.setPage(page);
                commandResult.setType(NavigationType.REDIRECT);
        }else {
            /*response.sendRedirect(request.getContextPath() + "/profile/error.jsp");*/
        }
        return commandResult;
    }
}
