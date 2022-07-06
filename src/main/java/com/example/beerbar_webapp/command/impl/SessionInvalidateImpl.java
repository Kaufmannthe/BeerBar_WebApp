package com.example.beerbar_webapp.command.impl;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.command.NavigationType;
import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.util.PageManager;
import com.example.beerbar_webapp.util.PageMappingConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionInvalidateImpl implements Command {
    JDBConnection jdbConnection = new JDBConnection();
    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult = new CommandResult();
        String page;
        HttpSession session = request.getSession();
        session.invalidate();

        try {
            jdbConnection.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        page = request.getContextPath() + PageManager.getPageURL(PageMappingConst.PAGE_LANDING.getKey());
        commandResult.setPage(page);
        commandResult.setType(NavigationType.REDIRECT);

        return commandResult;
    }
}
