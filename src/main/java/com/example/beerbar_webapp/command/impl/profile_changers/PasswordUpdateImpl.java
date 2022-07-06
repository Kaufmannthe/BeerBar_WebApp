package com.example.beerbar_webapp.command.impl.profile_changers;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.command.NavigationType;
import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;
import com.example.beerbar_webapp.util.PageManager;
import com.example.beerbar_webapp.util.PageMappingConst;
import com.example.beerbar_webapp.util.PageMappingConstErrors;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class PasswordUpdateImpl implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        JDBConnection connection = new JDBConnection();
        UserDAOImpl userDAO = new UserDAOImpl(connection);

        CommandResult commandResult = new CommandResult();
        String page;

        String password = request.getParameter("password");
        String login = request.getParameter("login");
        String passwordConf = request.getParameter("password-conf");
        User user = new User(login, password);


        if (userDAO.update(user) && Objects.equals(password, passwordConf) && password != null && password.length() > 6) {
                page = request.getContextPath() + PageManager.getPageURL(PageMappingConst.PAGE_SUCCESS_UPDATE.getKey());
                commandResult.setPage(page);
                commandResult.setType(NavigationType.REDIRECT);
        } else {
            page = request.getContextPath() + PageManager.getPageURL(PageMappingConstErrors.PASSWORD_ERROR.getKey());
            commandResult.setPage(page);
            commandResult.setType(NavigationType.REDIRECT);
        }
        return commandResult;
    }
}
